package com.stal111.frostbite_expansion.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author stal111
 * @since 2022-12-04
 */
public interface SnowloggableBlock {

    IntegerProperty SNOWLOGGED = IntegerProperty.create("snowlogged", 0, 8);

    VoxelShape[] SHAPE_BY_LAYER = new VoxelShape[]{
            Shapes.empty(),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };


    default int getSnowHeight(BlockState state) {
        return state.getValue(SNOWLOGGED);
    }

    default BlockState increaseSnowHeight(BlockState state) {
        return state.cycle(SNOWLOGGED);
    }

    default VoxelShape getCombinedShape(VoxelShape shape, BlockState state) {
        return Shapes.or(shape, SHAPE_BY_LAYER[this.getSnowHeight(state)]);
    }

    default VoxelShape getCombinedCollisionShape(VoxelShape shape, BlockState state) {
        if (this.getSnowHeight(state) <= 1) {
            return shape;
        }
        return Shapes.or(shape, SHAPE_BY_LAYER[this.getSnowHeight(state) - 1]);
    }
}
