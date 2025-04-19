package net.blockpainter.newadventures.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.blockpainter.newadventures.worldgen.tree.ModFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.Random;

import static com.mojang.serialization.Codec.floatRange;

public class YiraFoliagePlacer extends FoliagePlacer {
    public final IntProvider height;
    private final float wideBottomLayerHoleChance;
    private final float cornerHoleChance;
    private final float hangingLeavesChance;
    private final float hangingLeavesExtensionChance;

    public static final Codec<YiraFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            foliagePlacerParts(instance).and(instance.group(
                    IntProvider.codec(2, 16).fieldOf("height").forGetter(p -> p.height),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("wide_bottom_layer_hole_chance").forGetter(p -> p.wideBottomLayerHoleChance),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("corner_hole_chance").forGetter(p -> p.cornerHoleChance),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_chance").forGetter(p -> p.hangingLeavesChance),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_extension_chance").forGetter(p -> p.hangingLeavesExtensionChance)
            )).apply(instance, YiraFoliagePlacer::new)
    );

    public YiraFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height,
                             float wideBottomLayerHoleChance, float cornerHoleChance,
                             float hangingLeavesChance, float hangingLeavesExtensionChance) {
        super(radius, offset);
        this.height = height;
        this.wideBottomLayerHoleChance = wideBottomLayerHoleChance;
        this.cornerHoleChance = cornerHoleChance;
        this.hangingLeavesChance = hangingLeavesChance;
        this.hangingLeavesExtensionChance = hangingLeavesExtensionChance;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.YIRA_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        boolean flag = pAttachment.doubleTrunk();
        BlockPos blockpos = pAttachment.pos().above(pOffset);
        int i = pFoliageRadius + pAttachment.radiusOffset() - 1;
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i - 2, pFoliageHeight - 3, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i - 1, pFoliageHeight - 4, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, -3 , pFoliageHeight - 2, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, -4 , pFoliageHeight - 1, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, -6 , pFoliageHeight , flag);

        for(int j = pFoliageHeight - 5; j >= 0; --j) {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, j, flag);
        }


        this.placeLeavesRowWithHangingLeavesBelow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, -1, flag, getRandomFloatInRange(0.0F, 1.0F), getRandomFloatInRange(0.0F, 1.0F));
        this.placeLeavesRowWithHangingLeavesBelow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i - 1, -2, flag, getRandomFloatInRange(0.0F, 1.0F), getRandomFloatInRange(0.0F, 1.0F));
    }
    private static final Random RANDOM = new Random();
    public static float getRandomFloatInRange(float min, float max) {
        if (min >= max) {
            throw new IllegalArgumentException("min must be less than max");
        }
        return min + RANDOM.nextFloat() * (max - min);
    }



    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height.sample(pRandom);
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
