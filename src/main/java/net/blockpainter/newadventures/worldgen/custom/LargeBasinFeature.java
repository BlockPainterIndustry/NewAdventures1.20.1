package net.blockpainter.newadventures.worldgen.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class LargeBasinFeature extends Feature<NoneFeatureConfiguration> {
    public LargeBasinFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos center = context.origin();
        LevelAccessor world = context.level();
        RandomSource random = context.random();

        int radius = 10 + random.nextInt(6);
        int maxDepth = 5 + random.nextInt(2);

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                for (int y = 0; y < 100; y++) {
                    BlockPos pos = center.offset(x, y, z);
                    world.setBlock(pos, Blocks.RED_STAINED_GLASS.defaultBlockState(), 2);
                }
                /*double distance = Math.sqrt(x * x + z * z);
                double noise = 0.80 + (random.nextDouble() - 0.5) * 0.4; // 0.80 +- 0.2 = 1.0 - 0.6
                double shape = (distance / radius) * noise;

                if (shape <= 1.0) {
                    int depth = (int) ((1.0 - shape) * maxDepth);
                    for (int y = 0; y <= depth; y++) {
                        BlockPos pos = center.offset(x, -y, z);

                        if (!hasAirNearby(world, pos)) {
                            if (y == depth) {
                                world.setBlock(pos, Blocks.SANDSTONE.defaultBlockState(), 2);
                            } else if (y > 0) {
                                world.setBlock(pos, Blocks.RED_STAINED_GLASS.defaultBlockState(), 2);
                            } else {
                                world.setBlock(pos, Blocks.SAND.defaultBlockState(), 2);
                            }
                        } else {
                            BlockPos shiftedPos = pos.below();
                            if (!hasAirNearby(world, shiftedPos)) {
                                if (y == depth) {
                                    world.setBlock(shiftedPos, Blocks.SANDSTONE.defaultBlockState(), 2);
                                } else if (y > 0) {
                                    world.setBlock(shiftedPos, Blocks.RED_STAINED_GLASS.defaultBlockState(), 2);
                                } else {
                                    world.setBlock(shiftedPos, Blocks.SAND.defaultBlockState(), 2);
                                }
                            }
                        }
                    }

                    BlockPos edge = center.offset(x, 1, z);
                    BlockPos below = edge.below();
                    if (!world.isEmptyBlock(below) && world.getBlockState(below).isSolid()) {
                        world.setBlock(edge, Blocks.SAND.defaultBlockState(), 2);
                    }
                }*/
            }
        }

        return true;
    }

    // Methode, um zu prüfen, ob in der Nähe des Blocks Luft ist
    private boolean hasAirNearby(LevelAccessor world, BlockPos pos) {
        // Überprüft die 8 benachbarten Blöcke und den Block selbst
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    BlockPos neighbor = pos.offset(dx, dy, dz);
                    // Vermeide den Block selbst
                    if (dx == 0 && dy == 0 && dz == 0) continue;
                    if (world.isEmptyBlock(neighbor)) {
                        return true; // Wenn ein benachbarter Block Luft ist, gibt es Luft in der Nähe
                    }
                }
            }
        }
        return false; // Wenn keiner der benachbarten Blöcke Luft ist
    }
}
