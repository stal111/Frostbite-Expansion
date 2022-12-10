package com.stal111.frostbite_expansion.common.block.entity;

import com.stal111.frostbite_expansion.core.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * @author stal111
 * @since 2022-12-10
 */
public class IceLilyBlockEntity extends BlockEntity {

    public static final Vec3i[] OFFSETS = {
            new Vec3i(-1, 0, -1),
            new Vec3i(-1, 0, 0),
            new Vec3i(-1, 0, 1),
            new Vec3i(0, 0, 1),
            new Vec3i(1, 0, 1),
            new Vec3i(1, 0, 0),
            new Vec3i(1, 0, -1),
            new Vec3i(0, 0, -1),
    };

    public IceLilyBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ICE_LILY.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, IceLilyBlockEntity blockEntity) {
        if (level.getGameTime() % 20 != 0) {
            return;
        }

        for (Vec3i vec : OFFSETS) {
            BlockPos offsetPos = pos.offset(vec.below());
            BlockState offsetState = level.getBlockState(offsetPos);

            if (offsetState.is(Blocks.WATER) && level.random.nextDouble() < 0.1D) {
                level.setBlockAndUpdate(offsetPos, Blocks.ICE.defaultBlockState());
            }
        }
    }
}
