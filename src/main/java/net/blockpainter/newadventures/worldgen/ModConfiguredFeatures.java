package net.blockpainter.newadventures.worldgen;


import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> YIRA_KEY = registerKey("yira");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, YIRA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.YIRA_LOG.get()),
                new ForkingTrunkPlacer(4,4,3),

                BlockStateProvider.simple(ModBlocks.YIRA_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}