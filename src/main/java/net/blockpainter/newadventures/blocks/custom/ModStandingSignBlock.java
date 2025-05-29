package net.blockpainter.newadventures.blocks.custom;

import net.blockpainter.newadventures.blocks.entity.ModSignBlockEntity;
import net.blockpainter.newadventures.blocks.entity.ModSignType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModStandingSignBlock extends StandingSignBlock {
    private final ModSignType signType;

    public ModStandingSignBlock(Properties properties, WoodType woodType, ModSignType signType) {
        super(properties, woodType);
        this.signType = signType;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModSignBlockEntity(signType, pos, state);
    }
}
