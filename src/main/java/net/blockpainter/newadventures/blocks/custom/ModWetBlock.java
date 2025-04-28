package net.blockpainter.newadventures.blocks.custom;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWetBlock extends Block {
    public ModWetBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (isExposedToSunOrHeat(level, pos)) {
            Block newBlock = getDryVersion(state.getBlock()); // <-- hier geändert!
            if (newBlock != null) {
                level.setBlockAndUpdate(pos, newBlock.defaultBlockState());
            }
        }
    }

    private boolean isExposedToSunOrHeat(Level level, BlockPos pos) {
        if (level.canSeeSky(pos.above()) && level.getBrightness(LightLayer.SKY, pos.above()) >= 15) {
            return true;
        }
        for (Direction direction : Direction.values()) {
            BlockPos adjacentPos = pos.relative(direction);

            if (level.getBrightness(LightLayer.BLOCK, adjacentPos) >= 10) {
                return true;
            }
        }
        return false;
    }

    private Block getDryVersion(Block block) {
        ResourceLocation registryName = ForgeRegistries.BLOCKS.getKey(block);
        if (registryName == null) return null;

        if (registryName.getPath().contains("wet_gray")) {
            String dryPath = registryName.getPath().replace("wet_", "");
            ResourceLocation dryId = new ResourceLocation(NewAdventures.MODID, dryPath);
            return ForgeRegistries.BLOCKS.getValue(dryId);
        } else if (registryName.getPath().contains("wet_sand")) {
            String dryPath = registryName.getPath().replace("wet_", "");
            ResourceLocation dryId = new ResourceLocation("minecraft", dryPath);
            return ForgeRegistries.BLOCKS.getValue(dryId);
        } else if (registryName.getPath().contains("wet_red")) {
            String dryPath = registryName.getPath().replace("wet_", "");
            ResourceLocation dryId = new ResourceLocation("minecraft", dryPath);
            return ForgeRegistries.BLOCKS.getValue(dryId);
        } else {
            return null;
        }
    }
}
