package net.blockpainter.newadventures.worldgen.tree;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.worldgen.tree.custom.YiraTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, NewAdventures.MODID);

    public static final RegistryObject<TrunkPlacerType<YiraTrunkPlacer>> YIRA_TRUNK_PLACER =
            TRUNK_PLACER.register("yira_trunk_placer", () -> new TrunkPlacerType<>(YiraTrunkPlacer.CODEC));

}
