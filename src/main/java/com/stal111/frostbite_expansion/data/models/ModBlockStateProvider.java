package com.stal111.frostbite_expansion.data.models;

import com.stal111.frostbite_expansion.FrostbiteExpansion;
import com.stal111.frostbite_expansion.core.registry.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
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
        take(block -> wallBlock((WallBlock) block, modLoc("block/packed_snow")), ModBlocks.PACKED_SNOW_WALL);
        take(block -> wallBlock((WallBlock) block, modLoc("block/packed_snow_bricks")), ModBlocks.PACKED_SNOW_BRICK_WALL);

        take(this::simpleBlock,
                ModBlocks.PACKED_SNOW,
                ModBlocks.PACKED_SNOW_BRICKS,
                ModBlocks.CARVED_PACKED_SNOW
        );

        take(block -> this.stairsBlock((StairBlock) block, modLoc("block/packed_snow")), ModBlocks.PACKED_SNOW_STAIRS);
        take(block -> this.stairsBlock((StairBlock) block, modLoc("block/packed_snow_bricks")), ModBlocks.PACKED_SNOW_BRICK_STAIRS);

        take(block -> this.slabBlock((SlabBlock) block, modLoc("block/packed_snow"), modLoc("block/packed_snow_slab_side"), modLoc("block/packed_snow"), modLoc("block/packed_snow")), ModBlocks.PACKED_SNOW_SLAB);
        take(block -> this.slabBlock((SlabBlock) block, modLoc("block/packed_snow_bricks"), modLoc("block/packed_snow_bricks")), ModBlocks.PACKED_SNOW_BRICK_SLAB);
    }
}
