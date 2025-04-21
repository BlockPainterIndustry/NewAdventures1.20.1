package net.blockpainter.newadventures.blocks.custom;

import net.blockpainter.newadventures.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class ModShortGrassBlock extends ModBushBlock {
    public ModShortGrassBlock(Properties p_51021_) {
        super(p_51021_);
    }

    protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
        return p_51042_.is(ModTags.BLocks.YIRA_DIRT) /*|| p_51042_.is(Blocks.FARMLAND)*/;
    }

    public boolean canSurvive(BlockState p_51028_, LevelReader world, BlockPos pos) {
        BlockPos below = pos.below();
        return mayPlaceOn(world.getBlockState(below), world, below);
    }

    public boolean propagatesSkylightDown(BlockState p_51039_, BlockGetter p_51040_, BlockPos p_51041_) {
        return p_51039_.getFluidState().isEmpty();
    }

    public boolean isPathfindable(BlockState p_51023_, BlockGetter p_51024_, BlockPos p_51025_, PathComputationType p_51026_) {
        return p_51026_ == PathComputationType.AIR && !this.hasCollision ? true : super.isPathfindable(p_51023_, p_51024_, p_51025_, p_51026_);
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return defaultBlockState();
        return state;
    }


}
