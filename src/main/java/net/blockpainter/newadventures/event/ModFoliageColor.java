package net.blockpainter.newadventures.event;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NewAdventures.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModFoliageColor {

    @SubscribeEvent
    public static void onRegisterBlockColors(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register(
                (state, world, pos, tintIndex) -> {
                    return world != null && pos != null
                            ? BiomeColors.getAverageFoliageColor(world, pos)
                            : FoliageColor.getDefaultColor();
                },
                ModBlocks.PALME_LEAVES.get()
        );
    }

    @SubscribeEvent
    public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register(
                (stack, tintIndex) -> FoliageColor.getDefaultColor(),
                ModBlocks.PALME_LEAVES.get()
        );
    }
}
