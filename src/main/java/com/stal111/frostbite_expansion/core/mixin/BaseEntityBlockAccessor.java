package com.stal111.frostbite_expansion.core.mixin;

import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BaseEntityBlock.class)
public interface BaseEntityBlockAccessor {
    @Invoker
    static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> callCreateTickerHelper(BlockEntityType<A> p_152133_, BlockEntityType<E> p_152134_, BlockEntityTicker<? super E> p_152135_) {
        throw new UnsupportedOperationException();
    }
}
