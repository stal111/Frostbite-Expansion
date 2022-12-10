package com.stal111.frostbite_expansion.core.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.stal111.frostbite_expansion.common.block.SnowloggableBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.model.data.ModelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author stal111
 * @since 2022-12-04
 */
@Mixin(ModelBlockRenderer.class)
public abstract class ModelBlockRendererMixin {

    @Shadow public abstract void tesselateBlock(BlockAndTintGetter p_111048_, BakedModel p_111049_, BlockState p_111050_, BlockPos p_111051_, PoseStack p_111052_, VertexConsumer p_111053_, boolean p_111054_, RandomSource p_111055_, long p_111056_, int p_111057_, ModelData modelData, RenderType renderType);

    @Inject(
            at = @At(value = "RETURN"),
            method = "tesselateBlock(Lnet/minecraft/world/level/BlockAndTintGetter;Lnet/minecraft/client/resources/model/BakedModel;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;ZLnet/minecraft/util/RandomSource;JILnet/minecraftforge/client/model/data/ModelData;Lnet/minecraft/client/renderer/RenderType;)V",
            remap = false
    )
    private void frostbiteExpansion_tesselateBlock(BlockAndTintGetter level, BakedModel model, BlockState state, BlockPos pos, PoseStack poseStack, VertexConsumer consumer, boolean checkSides, RandomSource random, long seed, int packedOverlay, ModelData modelData, RenderType renderType, CallbackInfo ci) {
        if (state.getBlock() instanceof SnowloggableBlock snowloggableBlock) {
            int snowHeight = snowloggableBlock.getSnowHeight(state);

            if (snowHeight == 0) {
                return;
            }

            Vec3 offset = state.getOffset(level, pos);
            poseStack.translate(-offset.x, -offset.y - 0.00001, -offset.z);

            state = Blocks.SNOW.defaultBlockState().setValue(BlockStateProperties.LAYERS, snowHeight);
            model = Minecraft.getInstance().getBlockRenderer().getBlockModel(state);

            this.tesselateBlock(level, model, state, pos, poseStack, consumer, checkSides, random, seed, packedOverlay, modelData, renderType);
        }
    }
}
