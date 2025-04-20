package net.blockpainter.newadventures.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

public class YiraShortGrass extends BushBlock {
    public YiraShortGrass(Properties p_51021_) {
        super(p_51021_);
    }

    protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
        return p_51042_.is(BlockTags.YIRA_GRASS) /*|| p_51042_.is(Blocks.FARMLAND)*/;
    }
}
