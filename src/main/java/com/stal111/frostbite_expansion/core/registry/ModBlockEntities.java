package com.stal111.frostbite_expansion.core.registry;

import com.stal111.frostbite_expansion.FrostbiteExpansion;
import com.stal111.frostbite_expansion.common.block.entity.IceLilyBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_core.core.registry.RegistryClass;
import net.valhelsia.valhelsia_core.core.registry.helper.RegistryHelper;

/**
 * @author stal111
 * @since 2022-12-03
 */
public class ModBlockEntities implements RegistryClass {

    public static final RegistryHelper<BlockEntityType<?>> HELPER = FrostbiteExpansion.REGISTRY_MANAGER.getHelper(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES);

    public static final RegistryObject<BlockEntityType<IceLilyBlockEntity>> ICE_LILY = HELPER.register("ice_lily", () -> BlockEntityType.Builder.of(IceLilyBlockEntity::new, ModBlocks.ICE_LILY.get()).build(null));

}
