package net.blockpainter.newadventures.worldgen.carver.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

import java.util.function.Function;

public class LargeLakeCarver extends WorldCarver<CaveCarverConfiguration> {

    public LargeLakeCarver(Codec<CaveCarverConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean isStartChunk(CaveCarverConfiguration config, RandomSource random) {
        return random.nextFloat() < config.probability;
    }

    @Override
    public boolean carve(CarvingContext context, CaveCarverConfiguration config, ChunkAccess chunk,
                         Function<BlockPos, Holder<Biome>> biomeGetter, RandomSource random, Aquifer aquifer,
                         ChunkPos chunkPos, CarvingMask mask) {

        int worldX = chunkPos.getMinBlockX() + 8;
        int worldZ = chunkPos.getMinBlockZ() + 8;
        long seed = chunkPos.toLong();
        RandomSource seededRandom = RandomSource.create(seed);

        if (seededRandom.nextInt(16) != 0) return false;

        BlockPos center = new BlockPos(worldX, 62, worldZ);
        int radiusXZ = 30 + seededRandom.nextInt(10); // Bis 40 Blöcke breit
        int depth = 6 + seededRandom.nextInt(4);       // Tiefe

        carveLake(chunk, center, radiusXZ, depth, chunkPos, mask);

        return true;
    }

    private void carveLake(ChunkAccess chunk, BlockPos center, int radiusXZ, int depth,
                           ChunkPos chunkPos, CarvingMask mask) {

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int minY = center.getY() - depth;
        int maxY = center.getY();

        for (int dx = -radiusXZ; dx <= radiusXZ; dx++) {
            for (int dz = -radiusXZ; dz <= radiusXZ; dz++) {
                double dist = Math.sqrt(dx * dx + dz * dz);
                if (dist > radiusXZ) continue;

                for (int dy = minY; dy <= maxY; dy++) {
                    int x = center.getX() + dx;
                    int y = dy;
                    int z = center.getZ() + dz;

                    if (ChunkPos.getX(x) != chunkPos.x || ChunkPos.getZ(z) != chunkPos.z) continue;

                    pos.set(x, y, z);

                    // Prüfe alle Nachbarn, ob sie außerhalb des Carving-Bereichs liegen
                    boolean shouldPlaceConcrete = false;
                    for (Direction dir : Direction.values()) {
                        BlockPos neighbor = pos.relative(dir);
                        double dxn = neighbor.getX() - center.getX();
                        double dzn = neighbor.getZ() - center.getZ();
                        double distNeighbor = Math.sqrt(dxn * dxn + dzn * dzn);

                        if (distNeighbor > radiusXZ) {
                            shouldPlaceConcrete = true;
                            break;
                        }
                    }

                    if (shouldPlaceConcrete) {
                        chunk.setBlockState(pos, Blocks.RED_CONCRETE.defaultBlockState(), false);
                    } else if (y == maxY) {
                        chunk.setBlockState(pos, Blocks.WATER.defaultBlockState(), false);
                    } else {
                        chunk.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
                    }

                    mask.set(x & 15, y, z & 15);
                }
            }
        }
    }
}