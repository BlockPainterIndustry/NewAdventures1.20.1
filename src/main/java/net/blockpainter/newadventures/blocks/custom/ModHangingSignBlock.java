package net.blockpainter.newadventures.blocks.custom;

import net.blockpainter.newadventures.blocks.entity.ModHangingSignBlockEntity;
import net.blockpainter.newadventures.blocks.entity.ModSignType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModHangingSignBlock extends CeilingHangingSignBlock {
    private final ModSignType signType;

    public ModHangingSignBlock(Properties properties, WoodType type, ModSignType signType) {
        super(properties, type);
        this.signType = signType;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModHangingSignBlockEntity(signType, pos, state);
    }
}
