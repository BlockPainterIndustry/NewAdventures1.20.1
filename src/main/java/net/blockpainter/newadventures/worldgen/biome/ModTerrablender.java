package net.blockpainter.newadventures.worldgen.biome;

import net.blockpainter.newadventures.NewAdventures;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {

        public static void registerBiomes() {
            Regions.register(new ModOverworldRegion( new ResourceLocation(NewAdventures.MODID, "overworld"), 5));
        }


}
