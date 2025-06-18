package net.blockpainter.newadventures.worldgen.tree;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.worldgen.tree.custom.PalmeFoliagePlacer;
import net.blockpainter.newadventures.worldgen.tree.custom.YiraFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, NewAdventures.MODID);

    public static final RegistryObject<FoliagePlacerType<YiraFoliagePlacer>> YIRA_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("yira_foliage_placer", () -> new FoliagePlacerType<>(YiraFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<PalmeFoliagePlacer>> PALME_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("palme_foliage_placer", () -> new FoliagePlacerType<>(PalmeFoliagePlacer.CODEC));

}
