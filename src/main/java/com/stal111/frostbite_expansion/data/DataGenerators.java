package com.stal111.frostbite_expansion.data;

import com.stal111.frostbite_expansion.FrostbiteExpansion;
import com.stal111.frostbite_expansion.data.models.ModBlockStateProvider;
import com.stal111.frostbite_expansion.data.models.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.valhelsia.valhelsia_core.core.data.DataProviderInfo;

/**
 * @author stal111
 * @since 2022-12-03
 */
@Mod.EventBusSubscriber(modid = FrostbiteExpansion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        DataProviderInfo info = new DataProviderInfo(generator, existingFileHelper, FrostbiteExpansion.REGISTRY_MANAGER);

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, existingFileHelper));
    }
}
