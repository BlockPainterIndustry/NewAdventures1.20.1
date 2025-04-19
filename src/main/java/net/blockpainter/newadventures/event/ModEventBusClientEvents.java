package net.blockpainter.newadventures.event;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.entity.ModBlockEntities;
import net.blockpainter.newadventures.entity.client.ModModelLayers;
import net.blockpainter.newadventures.util.ModWoodTypes;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;

import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NewAdventures.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(ModModelLayers.YIRA_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.YIRA_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {

        event.registerBlockEntityRenderer(ModBlockEntities.YIRA_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.YIRA_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}
