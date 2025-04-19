package net.blockpainter.newadventures.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.blockpainter.newadventures.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class YiraTrunkPlacer extends TrunkPlacer {
    public static final Codec<YiraTrunkPlacer> CODEC = RecordCodecBuilder.create(yiraTrunkPlacerInstance ->
            trunkPlacerParts(yiraTrunkPlacerInstance).apply(yiraTrunkPlacerInstance, YiraTrunkPlacer::new));

    public YiraTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.YIRA_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter,
                                                            RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {

        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        int what = Math.max(0, pFreeTreeHeight + 1 + 2);
        int jw = Math.max(0, pFreeTreeHeight + 1 + 2);
        if (jw >= what) ++jw;

        int k = 3;
        boolean flag = k == 3;
        boolean flag1 = k >= 2;
        int height;
        if (flag) {
            height = pFreeTreeHeight;
        } else if (flag1) {
            height = Math.max(what, jw + 2);
        } else {
            height = jw + 1;
        }

        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();

        for (int ij = 0; ij < height; ij++) {
            BlockPos logPos = pPos.above(ij);
            placeLog(pLevel, pBlockSetter, pRandom, logPos, pConfig);

            float baseChance = 0.05f;
            float perLevelBonus = 0.05f;
            float chance = baseChance + (perLevelBonus * ij);

            if (ij > 2 && pRandom.nextFloat() < chance) {
                int length = pRandom.nextInt(1, 4);
                Direction[] dirs = Direction.Plane.HORIZONTAL.stream().toArray(Direction[]::new);
                Direction horDir = dirs[pRandom.nextInt(dirs.length)];

                BlockPos branchPos = logPos;
                boolean lastWasSameLevel = false;

                for (int step = 0; step < length; step++) {
                    int up = pRandom.nextInt(2); // 0 oder 1
                    branchPos = branchPos.relative(horDir).relative(Direction.UP, up);

                    Direction.Axis axis;
                    if (up == 1) {
                        axis = Direction.Axis.Y;
                        lastWasSameLevel = false;
                    } else {
                        if (!lastWasSameLevel) {
                            axis = horDir.getAxis();
                            lastWasSameLevel = true;
                        } else {
                            axis = Direction.Axis.Y;
                            lastWasSameLevel = false;
                        }
                    }

                    BlockState logState = pConfig.trunkProvider.getState(pRandom, branchPos).setValue(RotatedPillarBlock.AXIS, axis);
                    pBlockSetter.accept(branchPos, logState);
                }

                foliageAttachments.add(new FoliagePlacer.FoliageAttachment(branchPos, -2, false));
            }
        }

        foliageAttachments.add(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));

        return foliageAttachments;
    }
}
