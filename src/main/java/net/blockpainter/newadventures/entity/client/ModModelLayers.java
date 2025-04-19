package net.blockpainter.newadventures.entity.client;

import net.blockpainter.newadventures.NewAdventures;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

    public static final ModelLayerLocation YIRA_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "boat/yira"), "main");
    public static final ModelLayerLocation YIRA_CHEST_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "chest_boat/yira"), "main");
}