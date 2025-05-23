package net.blockpainter.newadventures.worldgen;

import net.blockpainter.newadventures.worldgen.custom.LargeBasinFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, "yourmodid");

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LARGE_BASIN =
            FEATURES.register("large_basin", LargeBasinFeature::new);

    public static void register(IEventBus bus) {
        FEATURES.register(bus);
    }
}
