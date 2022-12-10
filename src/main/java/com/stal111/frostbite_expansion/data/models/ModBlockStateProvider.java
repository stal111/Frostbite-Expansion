package com.stal111.frostbite_expansion.data.models;

import com.stal111.frostbite_expansion.FrostbiteExpansion;
import com.stal111.frostbite_expansion.core.registry.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaBlockStateProvider;

/**
 * @author stal111
 * @since 2022-12-03
 */
public class ModBlockStateProvider extends ValhelsiaBlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, FrostbiteExpansion.REGISTRY_MANAGER, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        take(this::withExistingModel,
                ModBlocks.ICE_LILY
        );
    }
}
