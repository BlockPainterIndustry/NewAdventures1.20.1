package net.blockpainter.newadventures.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.blockpainter.newadventures.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class PalmeTrunkPlacer extends TrunkPlacer {
    public static final Codec<PalmeTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            trunkPlacerParts(instance)
                    .and(Codec.FLOAT.fieldOf("more_curve").forGetter(p -> p.moreCurve))
                    .apply(instance, PalmeTrunkPlacer::new)
    );

    private final float moreCurve;

    public PalmeTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, float moreCurve) {
        super(baseHeight, heightRandA, heightRandB);
        this.moreCurve = moreCurve;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.PALME_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level,
                                                            BiConsumer<BlockPos, BlockState> blockSetter,
                                                            RandomSource random, int freeTreeHeight,
                                                            BlockPos pos, TreeConfiguration config) {
        setDirtAt(level, blockSetter, random, pos.below(), config);

        int height = freeTreeHeight;

        List<FoliagePlacer.FoliageAttachment> attachments = new ArrayList<>();
        BlockPos currentPos = pos;
        Direction fixedCurveDirection = null;

        for (int i = 0; i < freeTreeHeight; i++) {
            placeLog(level, blockSetter, random, currentPos, config);

            float baseChance = 0.05f;
            float per3BlockIncrease = 0.01f;
            float curveChance = baseChance + (i / 3) * per3BlockIncrease + moreCurve;

            if (random.nextFloat() < curveChance) {
                if (fixedCurveDirection == null) {
                    fixedCurveDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                }

                currentPos = currentPos.relative(fixedCurveDirection).above();
            } else {
                currentPos = currentPos.above();
            }
        }

        attachments.add(new FoliagePlacer.FoliageAttachment(currentPos, 0, false));
        return attachments;
    }
}
