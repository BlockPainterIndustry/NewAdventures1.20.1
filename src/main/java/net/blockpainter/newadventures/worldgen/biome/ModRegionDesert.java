package net.blockpainter.newadventures.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModRegionDesert extends Region {

    public ModRegionDesert(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(Climate.Parameter.span(1.5F, 2.0F))
                .humidity(Climate.Parameter.span(0.0F, 0.5F))
                .continentalness(Climate.Parameter.span(0.1F, 1.0F))
                .erosion(Climate.Parameter.span(0.0F, 1.0F))
                .depth(Climate.Parameter.point(0.0F))
                .weirdness(Climate.Parameter.span(-0.25F, 0.25F))
                .build().forEach(p -> builder.add(p, ModBiomes.DESERT_OASIS));
        builder.build().forEach(mapper);
    }
}
