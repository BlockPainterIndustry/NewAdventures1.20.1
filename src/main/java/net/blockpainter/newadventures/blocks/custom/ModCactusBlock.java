package net.blockpainter.newadventures.blocks.custom;

import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModCactusBlock extends CactusBlock {
    public ModCactusBlock(Properties p_51136_) {
        super(p_51136_);
    }

    @Override
    public net.minecraftforge.common.PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return net.minecraftforge.common.PlantType.DESERT;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // Check for collision with solid blocks or lava
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState adjacentState = level.getBlockState(pos.relative(direction));
            if (adjacentState.isSolid() || level.getFluidState(pos.relative(direction)).is(FluidTags.LAVA)) {
                return false;
            }
        }

        // Block unter dem Cactus
        BlockState belowState = level.getBlockState(pos.below());

        // Zulässige Untergründe:
        return (belowState.is(Blocks.SAND) || belowState.is(Blocks.RED_SAND) || belowState.is(ModBlocks.GRAY_SAND.get()) || belowState.is(this)) && !level.getBlockState(pos.above()).liquid();
    }
}
