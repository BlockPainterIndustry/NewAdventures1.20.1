package net.blockpainter.newadventures.entity.client;

import net.blockpainter.newadventures.NewAdventures;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

    public static final ModelLayerLocation YIRA_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(NewAdventures.MODID, "boat/yira"), "main");
    public static final ModelLayerLocation YIRA_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(NewAdventures.MODID, "chest_boat/yira"), "main");

    public static final ModelLayerLocation PALME_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(NewAdventures.MODID, "boat/palme"), "main");
    public static final ModelLayerLocation PALME_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(NewAdventures.MODID, "chest_boat/palme"), "main");
}