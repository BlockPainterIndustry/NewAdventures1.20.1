package net.blockpainter.newadventures.worldgen;


import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;


import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> YIRA_PLACED_KEY = registerKey("yira_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, YIRA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.YIRA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.YIRA_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}