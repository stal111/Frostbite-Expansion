package com.stal111.frostbite_expansion;

import com.stal111.frostbite_expansion.core.registry.ModBlockEntities;
import com.stal111.frostbite_expansion.core.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.valhelsia.valhelsia_core.core.registry.RegistryCollector;

/**
 * @author stal111
 * @since 2023-01-30
 */
public class ModRegistries extends RegistryCollector {

    public ModRegistries(String modId) {
        super(modId);
    }

    @Override
    protected void collect() {
        this.addBlockHelper(ModBlocks::new);
        this.addItemHelper();
        this.addMappedHelper(Registries.BLOCK_ENTITY_TYPE, ModBlockEntities::new);
    }
}
