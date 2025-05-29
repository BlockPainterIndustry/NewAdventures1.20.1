package net.blockpainter.newadventures.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {
    private final ModSignType signType;

    public ModSignBlockEntity(ModSignType signType, BlockPos pos, BlockState state) {
        super(signType.blockEntityType().get(), pos, state);
        this.signType = signType;
    }

    @Override
    public BlockEntityType<?> getType() {
        return signType.blockEntityType().get();
    }

    public ModSignType getModSignType() {
        return signType;
    }
}
