package com.stal111.frostbite_expansion.core.mixin;

import com.stal111.frostbite_expansion.common.block.entity.IceLilyBlockEntity;
import com.stal111.frostbite_expansion.core.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author stal111
 * @since 2022-12-10
 */
@Mixin(IceBlock.class)
public class IceBlockMixin {

    @Inject(
            at = @At(value = "HEAD"),
            method = "melt",
            cancellable = true)
    public void frostbiteExpansion_melt(BlockState state, Level level, BlockPos pos, CallbackInfo ci) {
        BlockPos above = pos.above();

        for (Vec3i vec : IceLilyBlockEntity.OFFSETS) {
            if (level.getBlockState(above.offset(vec)).is(ModBlocks.ICE_LILY.get())) {
                ci.cancel();

                return;
            }
        }
    }
}
