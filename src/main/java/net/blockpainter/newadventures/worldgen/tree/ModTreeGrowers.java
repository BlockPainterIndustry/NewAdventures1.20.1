package net.blockpainter.newadventures.worldgen.tree;

import net.blockpainter.newadventures.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModTreeGrowers extends AbstractTreeGrower {
    private final SimpleWeightedRandomList<ResourceKey<ConfiguredFeature<?, ?>>> configuredFeatures;

    public ModTreeGrowers(SimpleWeightedRandomList<ResourceKey<ConfiguredFeature<?, ?>>> features) {
        this.configuredFeatures = features;
    }

    public static final ModTreeGrowers YIRA_TREE_GROWER = new ModTreeGrowers(
            SimpleWeightedRandomList.<ResourceKey<ConfiguredFeature<?, ?>>>builder()
                    .add(ModConfiguredFeatures.YIRA_KEY, 4)
                    .add(ModConfiguredFeatures.YIRA_TALL_KEY, 1)
                    .build()
    );

    public static final ModTreeGrowers PALME_TREE_GROWER = new ModTreeGrowers(
            SimpleWeightedRandomList.<ResourceKey<ConfiguredFeature<?, ?>>>builder()
                    .add(ModConfiguredFeatures.PALME_KEY, 2)
                    .add(ModConfiguredFeatures.PALME_TALL_KEY, 1)
                    .build()
    );

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
        return configuredFeatures.getRandomValue(random).orElse(null);
    }
}