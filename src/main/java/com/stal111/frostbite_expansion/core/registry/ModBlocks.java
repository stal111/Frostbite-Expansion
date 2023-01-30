package com.stal111.frostbite_expansion.core.registry;

import com.stal111.frostbite_expansion.FrostbiteExpansion;
import com.stal111.frostbite_expansion.common.block.IceLilyBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
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
    public static final RegistryObject<Block> PACKED_SNOW = HELPER.register("packed_snow", () -> new Block(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F).sound(SoundType.SNOW)));
    public static final RegistryObject<Block> PACKED_SNOW_BRICKS = HELPER.register("packed_snow_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F).sound(SoundType.SNOW)));
    public static final RegistryObject<Block> CARVED_PACKED_SNOW = HELPER.register("carved_packed_snow", () -> new Block(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F).sound(SoundType.SNOW)));
    public static final RegistryObject<StairBlock> PACKED_SNOW_STAIRS = HELPER.register("packed_snow_stairs", () -> new StairBlock(() -> PACKED_SNOW.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F).sound(SoundType.SNOW)));
    public static final RegistryObject<StairBlock> PACKED_SNOW_BRICK_STAIRS = HELPER.register("packed_snow_brick_stairs", () -> new StairBlock(() -> PACKED_SNOW_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F).sound(SoundType.SNOW)));
    public static final RegistryObject<SlabBlock> PACKED_SNOW_SLAB = HELPER.register("packed_snow_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F).sound(SoundType.SNOW)));
    public static final RegistryObject<SlabBlock> PACKED_SNOW_BRICK_SLAB = HELPER.register("packed_snow_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F).sound(SoundType.SNOW)));
    public static final RegistryObject<WallBlock> PACKED_SNOW_WALL = HELPER.register("packed_snow_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F).sound(SoundType.SNOW)));
    public static final RegistryObject<WallBlock> PACKED_SNOW_BRICK_WALL = HELPER.register("packed_snow_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.SNOW).strength(0.5F).sound(SoundType.SNOW)));

}
