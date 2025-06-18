package net.blockpainter.newadventures.worldgen;


import com.google.common.collect.ImmutableList;
import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> YIRA_PLACED_KEY = registerKey("yira_placed");

    //public static final ResourceKey<PlacedFeature> PALME_PLACED_KEY = registerKey("palme_placed");

    //public static final ResourceKey<PlacedFeature> PALME_TALL_PLACED_KEY = registerKey("palme_tall_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, YIRA_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.YIRA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks.YIRA_SAPLING.get())
        );

        /*register(context, PALME_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.PALME_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.4f, 2), ModBlocks.PALME_SAPLING.get())
        );

        register(context, PALME_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.PALME_TALL_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2), ModBlocks.PALME_SAPLING.get())
        );*/

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,  new ResourceLocation(NewAdventures.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }



}