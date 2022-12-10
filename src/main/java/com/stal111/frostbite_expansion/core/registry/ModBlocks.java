package com.stal111.frostbite_expansion.core.registry;

import com.stal111.frostbite_expansion.FrostbiteExpansion;
import com.stal111.frostbite_expansion.common.block.IceLilyBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_core.core.registry.RegistryClass;
import net.valhelsia.valhelsia_core.core.registry.helper.block.BlockRegistryHelper;

/**
 * @author stal111
 * @since 2022-12-03
 */
public class ModBlocks implements RegistryClass {

    public static final BlockRegistryHelper HELPER = FrostbiteExpansion.REGISTRY_MANAGER.getBlockHelper();

    public static final RegistryObject<Block> ICE_LILY = HELPER.register("ice_lily", () -> new IceLilyBlock(MobEffects.WATER_BREATHING, 12, BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY).dynamicShape()));

}
