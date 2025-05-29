package net.blockpainter.newadventures.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModHangingSignBlockEntity extends HangingSignBlockEntity {
    private final ModSignType signType;

    public ModHangingSignBlockEntity(ModSignType signType, BlockPos pos, BlockState state) {
        super(pos, state); // Nur BlockPos und BlockState
        this.signType = signType;
    }

    @Override
    public BlockEntityType<?> getType() {
        return signType.hangingBlockEntityType().get();
    }

    public ModSignType getModSignType() {
        return signType;
    }
}
