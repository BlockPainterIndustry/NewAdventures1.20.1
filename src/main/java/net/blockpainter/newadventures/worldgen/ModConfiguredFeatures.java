package net.blockpainter.newadventures.worldgen;


import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.worldgen.tree.custom.PalmeFoliagePlacer;
import net.blockpainter.newadventures.worldgen.tree.custom.PalmeTrunkPlacer;
import net.blockpainter.newadventures.worldgen.tree.custom.YiraFoliagePlacer;
import net.blockpainter.newadventures.worldgen.tree.custom.YiraTrunkPlacer;
import net.minecraft.core.registries.Registries;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> YIRA_KEY = registerKey("yira");

    public static final ResourceKey<ConfiguredFeature<?, ?>> YIRA_TALL_KEY = registerKey("yira_tall");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PALME_KEY = registerKey("palme");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PALME_TALL_KEY = registerKey("palme_tall");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, YIRA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.YIRA_LOG.get()),
                new YiraTrunkPlacer(4,4,3, 0F, false),

                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.YIRA_LEAVES.get().defaultBlockState(), 3).add(ModBlocks.FLOWERING_YiRA_LEAVES.get().defaultBlockState(), 1)),

                new YiraFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), ConstantInt.of(5), 0.25f, 0.25f, 0.166666667f, 0.33333334f),



                new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(ModBlocks.YIRA_GRASS_BLOCK.get())).build());

        register(context, YIRA_TALL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.YIRA_LOG.get()),
                new YiraTrunkPlacer(8,7,4, 0.15F, true),

                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.YIRA_LEAVES.get().defaultBlockState(), 3).add(ModBlocks.FLOWERING_YiRA_LEAVES.get().defaultBlockState(), 1)),

                new YiraFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), ConstantInt.of(5), 0.25f, 0.25f, 0.166666667f, 0.33333334f),

                new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(ModBlocks.YIRA_GRASS_BLOCK.get())).build());

        register(context, PALME_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PALME_LOG.get()),
                new PalmeTrunkPlacer(4,4,2 , 0.0f),

                BlockStateProvider.simple(ModBlocks.PALME_LEAVES.get()),

                new PalmeFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4), 0.7f, 0.4f
                ),

                new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.GRASS_BLOCK)).build());

        register(context, PALME_TALL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PALME_LOG.get()),
                new PalmeTrunkPlacer(6,5,3 , 0.1f),

                BlockStateProvider.simple(ModBlocks.PALME_LEAVES.get()),

                new PalmeFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(4), 0.5F, 0.2F),

                new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.GRASS_BLOCK)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,  new ResourceLocation(NewAdventures.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}