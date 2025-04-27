package net.blockpainter.newadventures.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CactusBlock;

public class ModCactusBlock extends CactusBlock {
    public ModCactusBlock(Properties p_51136_) {
        super(p_51136_);
    }

    @Override
    public net.minecraftforge.common.PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return net.minecraftforge.common.PlantType.DESERT;
    }
}
