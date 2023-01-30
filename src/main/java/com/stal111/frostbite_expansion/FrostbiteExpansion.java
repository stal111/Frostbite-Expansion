package com.stal111.frostbite_expansion;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.valhelsia.valhelsia_core.core.ValhelsiaMod;
import net.valhelsia.valhelsia_core.core.registry.RegistryManager;
import org.slf4j.Logger;

@Mod(FrostbiteExpansion.MOD_ID)
public class FrostbiteExpansion extends ValhelsiaMod {

    public static final String MOD_ID = "frostbite_expansion";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final RegistryManager REGISTRY_MANAGER = new RegistryManager(new ModRegistries(FrostbiteExpansion.MOD_ID), null);

    public FrostbiteExpansion() {
        super(FrostbiteExpansion.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus(), FrostbiteExpansion.REGISTRY_MANAGER);
    }
}
