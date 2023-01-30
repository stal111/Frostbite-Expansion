package com.stal111.frostbite_expansion.data.models;

import com.stal111.frostbite_expansion.core.registry.ModBlocks;
import net.valhelsia.valhelsia_core.core.data.DataProviderInfo;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaItemModelProvider;

/**
 * @author stal111
 * @since 2022-12-03
 */
public class ModItemModelProvider extends ValhelsiaItemModelProvider {

    public ModItemModelProvider(DataProviderInfo info) {
        super(info.output(), info.registryManager(), info.fileHelper());
    }

    @Override
    protected void registerModels() {
        takeBlockItem(this::simpleModel,
                ModBlocks.ICE_LILY
        );

        takeBlockItem(this::withParentInventory,
                ModBlocks.PACKED_SNOW_WALL,
                ModBlocks.PACKED_SNOW_BRICK_WALL
        );

        forEachBlockItem(this::withParent);
    }
}
