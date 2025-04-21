package net.blockpainter.newadventures.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public interface YiraBranchableBlock {
    boolean isValidYiraNramchTarget(LevelReader p_256559_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_);

    boolean isYiraBranchSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_, BlockState p_220881_);

    void performYiraBranch(ServerLevel p_220874_, RandomSource p_220875_, BlockPos p_220876_, BlockState p_220877_);
}
