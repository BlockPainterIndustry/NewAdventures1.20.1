package net.blockpainter.newadventures.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.blockpainter.newadventures.worldgen.tree.ModFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PalmeFoliagePlacer extends FoliagePlacer {
    public static final Codec<PalmeFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            foliagePlacerParts(instance).and(instance.group(
                    IntProvider.codec(2, 8).fieldOf("height").forGetter(p -> p.height),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_chance").forGetter(p -> p.hangingLeavesChance),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_extension_chance").forGetter(p -> p.hangingExtensionChance)
            )).apply(instance, PalmeFoliagePlacer::new)
    );

    private final IntProvider height;
    private final float hangingLeavesChance;
    private final float hangingExtensionChance;

    public PalmeFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height,
                              float hangingLeavesChance, float hangingExtensionChance) {
        super(radius, offset);
        this.height = height;
        this.hangingLeavesChance = hangingLeavesChance;
        this.hangingExtensionChance = hangingExtensionChance;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.PALME_FOLIAGE_PLACER.get();
    }

    @Override
    public void createFoliage(LevelSimulatedReader level, FoliageSetter setter, RandomSource random,
                              TreeConfiguration config, int height, FoliageAttachment attachment,
                              int foliageHeight, int foliageRadius, int offset) {

        BlockPos center = attachment.pos().above(offset);
        int radius = foliageRadius + 1;
        BlockPos mid = center.above();
        placeLeafSafe(level, setter, random, config, center);
        placeLeafSafe(level, setter, random, config, center.above());
        placeLeafSafe(level, setter, random, config, mid.above());

        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                if (dx != 0 || dz != 0) {
                    placeLeafSafe(level, setter, random, config, center.offset(dx, 0, dz));
                    if (random.nextFloat() < 0.6f) {
                        placeLeafSafe(level, setter, random, config, center.offset(dx, -1, dz));
                    }
                }
            }
        }

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            for (int i = 1; i <= radius + 1; i++) {
                BlockPos arm = center.relative(dir, i);
                placeLeafSafe(level, setter, random, config, arm);

                if (random.nextFloat() < 0.8f) {
                    placeLeafSafe(level, setter, random, config, arm.below());
                }
                if (random.nextFloat() < 0.5f) {
                    placeLeafSafe(level, setter, random, config, arm.below(2));
                }
            }
        }

        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                if (Math.abs(dx) == Math.abs(dz)) {
                    for (int i = 1; i <= radius; i++) {
                        BlockPos diag = center.offset(dx * i, 0, dz * i);
                        placeLeafSafe(level, setter, random, config, diag);
                        if (random.nextFloat() < 0.8f) {
                            placeLeafSafe(level, setter, random, config, diag.below());
                        }
                        if (random.nextFloat() < 0.4f) {
                            placeLeafSafe(level, setter, random, config, diag.below(2));
                        }
                    }
                }
            }
        }

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                if ((Math.abs(dx) + Math.abs(dz)) <= radius && random.nextFloat() < 0.2f) {
                    placeLeafSafe(level, setter, random, config, center.offset(dx, -1, dz));
                }
            }
        }
    }

    private void placeLeafSafe(LevelSimulatedReader level, FoliageSetter setter, RandomSource random,
                               TreeConfiguration config, BlockPos pos) {
        if (level.isStateAtPosition(pos, state -> state.isAir() || state.is(BlockTags.LEAVES))) {
            setter.set(pos, config.foliageProvider.getState(random, pos));
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return this.height.sample(random);
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return false;
    }
}
