package net.blockpainter.newadventures.worldgen.biome;

import net.blockpainter.newadventures.NewAdventures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;


public class ModBiomes {

    public static final ResourceKey<Biome> YIRA_BIOME = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(NewAdventures.MODID, "yira_biome"));
    /*public static final ResourceKey<Biome> DESERT_OASIS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(NewAdventures.MODID, "desert_oasis"));*/

    public static final ResourceKey<Biome> DESERT_OASIS = register2("desert_oasis");

    private static ResourceKey<Biome> register2(String name)
    {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(NewAdventures.MODID, name));
    }

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(YIRA_BIOME, yiraBiome(context));
        context.register(DESERT_OASIS, desertOasis(context));
    }

    public static Biome yiraBiome(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        return new Biome.BiomeBuilder()

                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x03e9b6)
                        .waterFogColor(0x03C195)
                        .skyColor(0x45B7C6)
                        .foliageColorOverride(0xF900ED)
                        .fogColor(0x2BADE5)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome desertOasis(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();



        BiomeDefaultFeatures.desertSpawns(spawnBuilder);


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder);
        /*biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_GRAVEL);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_GRANITE_LOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_GRANITE_UPPER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_DIORITE_LOWER);
        //biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_DIORITE_UPPER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_ANDESITE_LOWER);
        //biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_ANDESITE_UPPER);*/
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES,
                context.lookup(Registries.PLACED_FEATURE).getOrThrow(MiscOverworldPlacements.SPRING_WATER));
        biomeBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS,
                context.lookup(Registries.PLACED_FEATURE).getOrThrow(MiscOverworldPlacements.SPRING_WATER));
        return new Biome.BiomeBuilder()

                .hasPrecipitation(true)
                .downfall(0.1f)
                .temperature(1.6f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x03e9b6)
                        .waterFogColor(0x03C195)
                        .skyColor(0x45B7C6)
                        .foliageColorOverride(0xF900ED)
                        .fogColor(0x2BADE5)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(NewAdventures.MODID, name));
    }
}
