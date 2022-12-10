package com.stal111.frostbite_expansion;

import com.mojang.logging.LogUtils;
import com.stal111.frostbite_expansion.core.registry.ModBlockEntities;
import com.stal111.frostbite_expansion.core.registry.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.valhelsia.valhelsia_core.core.ValhelsiaMod;
import net.valhelsia.valhelsia_core.core.registry.RegistryManager;
import org.slf4j.Logger;

@Mod(FrostbiteExpansion.MOD_ID)
public class FrostbiteExpansion extends ValhelsiaMod {

    public static final String MOD_ID = "frostbite_expansion";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final RegistryManager REGISTRY_MANAGER = RegistryManager.builder(MOD_ID)
            .addBlockHelper(ForgeRegistries.Keys.BLOCKS, CreativeModeTab.TAB_MISC, ModBlocks::new)
            .addHelper(ForgeRegistries.Keys.ITEMS)
            .addHelper(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, ModBlockEntities::new)
            .create();

    public FrostbiteExpansion() {
        super(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
    }

    @Override
    public RegistryManager getRegistryManager() {
        return REGISTRY_MANAGER;
    }
}
