package com.stal111.frostbite_expansion.core.mixin;

import com.stal111.frostbite_expansion.common.block.SnowloggableBlock;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author stal111
 * @since 2022-12-03
 */
@Mixin(SnowLayerBlock.class)
public class SnowLayerBlockMixin {

    @Inject(
            at = @At(value = "HEAD"),
            method = "getStateForPlacement",
            cancellable = true)
    public void frostbiteExpansion_getStateForPlacement(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());

        if (state.getBlock() instanceof SnowloggableBlock snowloggableBlock && snowloggableBlock.getSnowHeight(state) != 8) {
            cir.setReturnValue(snowloggableBlock.increaseSnowHeight(state));
        }
    }
}
