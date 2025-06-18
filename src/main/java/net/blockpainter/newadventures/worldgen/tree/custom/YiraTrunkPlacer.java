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

public class YiraTrunkPlacer extends TrunkPlacer {
    public static final Codec<YiraTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            trunkPlacerParts(instance)
                    .and(Codec.FLOAT.fieldOf("branch_chance_multiplier").forGetter(tp -> tp.branchChanceMultiplier))
                    .and(Codec.BOOL.fieldOf("is_tall_var").forGetter(tp -> tp.isTallVar))
                    .apply(instance, YiraTrunkPlacer::new)
    );

    public final float branchChanceMultiplier;
    public final boolean isTallVar;

    public YiraTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, float branchChanceMultiplier, boolean isTallVar) {
        super(baseHeight, heightRandA, heightRandB);
        this.branchChanceMultiplier = branchChanceMultiplier;
        this.isTallVar = isTallVar;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.YIRA_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter,
                                                            RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {

        setDirtAt(level, blockSetter, random, pos.below(), config);

        int height = freeTreeHeight;
        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            BlockPos currentPos = pos.above(i);

            // ↓ Sonderfall: isTallVar == true → setze Oak Log bei Höhe 3–6
            if (isTallVar && i >= 3 && i <= 6) {
                BlockState oakLog = net.minecraft.world.level.block.Blocks.OAK_LOG.defaultBlockState()
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y);
                blockSetter.accept(currentPos, oakLog);
            } else {
                placeLog(level, blockSetter, random, currentPos, config);
            }

            float baseChance = 0.05f;
            float perLevelBonus = 0.05f;
            float chance = baseChance + (perLevelBonus * i) + branchChanceMultiplier;

            if (i > 2 && random.nextFloat() < chance) {
                int length = random.nextInt(1, 4);
                Direction horDir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                BlockPos branchPos = currentPos;
                boolean lastWasSameLevel = false;

                for (int step = 0; step < length; step++) {
                    int up = random.nextInt(2);
                    branchPos = branchPos.relative(horDir).relative(Direction.UP, up);

                    Direction.Axis axis = (up == 1 || lastWasSameLevel) ? Direction.Axis.Y : horDir.getAxis();
                    lastWasSameLevel = !lastWasSameLevel;

                    BlockState logState = config.trunkProvider.getState(random, branchPos).setValue(RotatedPillarBlock.AXIS, axis);
                    blockSetter.accept(branchPos, logState);
                }

                foliageAttachments.add(new FoliagePlacer.FoliageAttachment(branchPos, -2, false));
            }
        }

        foliageAttachments.add(new FoliagePlacer.FoliageAttachment(pos.above(height), 0, false));
        return foliageAttachments;
    }
}