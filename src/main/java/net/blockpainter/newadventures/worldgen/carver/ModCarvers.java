package net.blockpainter.newadventures.worldgen.carver;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.worldgen.carver.custom.LargeLakeCarver;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCarvers {
    public static final DeferredRegister<WorldCarver<?>> CARVERS =
            DeferredRegister.create(Registries.CARVER, NewAdventures.MODID);

    public static final RegistryObject<WorldCarver<CaveCarverConfiguration>> LARGE_LAKE_CARVER =
            CARVERS.register("large_lake", () -> new LargeLakeCarver(CaveCarverConfiguration.CODEC));
}
