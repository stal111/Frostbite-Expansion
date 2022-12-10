package com.stal111.frostbite_expansion.data.models;

import com.stal111.frostbite_expansion.FrostbiteExpansion;
import com.stal111.frostbite_expansion.core.registry.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaItemModelProvider;

/**
 * @author stal111
 * @since 2022-12-03
 */
public class ModItemModelProvider extends ValhelsiaItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, FrostbiteExpansion.REGISTRY_MANAGER, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        takeBlockItem(this::simpleModel,
                ModBlocks.ICE_LILY
        );
    }
}
