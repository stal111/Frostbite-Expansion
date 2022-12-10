package com.stal111.frostbite_expansion.common.block;

import com.stal111.frostbite_expansion.common.block.entity.IceLilyBlockEntity;
import com.stal111.frostbite_expansion.core.mixin.BaseEntityBlockAccessor;
import com.stal111.frostbite_expansion.core.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

/**
 * @author stal111
 * @since 2022-12-03
 */
public class IceLilyBlock extends FlowerBlock implements SnowloggableBlock, EntityBlock {

    public IceLilyBlock(MobEffect suspiciousStewEffect, int effectDuration, Properties properties) {
        super(suspiciousStewEffect, effectDuration, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(SNOWLOGGED, 0));
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getCombinedShape(super.getShape(state, level, pos, context), state);
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getCombinedCollisionShape(super.getCollisionShape(state, level, pos, context), state);
    }

    @Override
    public @NotNull VoxelShape getBlockSupportShape(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos) {
        return this.getCombinedShape(super.getBlockSupportShape(state, reader, pos), state);
    }

    @Override
    public VoxelShape getVisualShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getCombinedShape(super.getVisualShape(state, level, pos, context), state);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new IceLilyBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());

        if (state.is(Blocks.SNOW)) {
            return this.defaultBlockState().setValue(SNOWLOGGED, 1);
        }

        return super.getStateForPlacement(context);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@Nonnull Level level, @Nonnull BlockState state, @Nonnull BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return null;
           // return BaseEntityBlockAccessor.callCreateTickerHelper(blockEntityType, ModBlockEntities.ICE_LILY.get(), IceLilyBlockEntity::clientTick);
        }
        return BaseEntityBlockAccessor.callCreateTickerHelper(blockEntityType, ModBlockEntities.ICE_LILY.get(), IceLilyBlockEntity::serverTick);
    }

    @Override
    public boolean canBeReplaced(@NotNull BlockState state, @NotNull BlockPlaceContext context) {
        return !context.isSecondaryUseActive() && context.getItemInHand().is(Items.SNOW) && state.getValue(SNOWLOGGED) != 8 || super.canBeReplaced(state, context);
    }

    @Override
    public float getShadeBrightness(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return this.getSnowHeight(state) == 8 ? 0.2F : 1.0F;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(SNOWLOGGED);
    }
}
