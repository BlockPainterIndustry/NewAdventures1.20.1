package net.blockpainter.newadventures;

import com.mojang.logging.LogUtils;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.blocks.entity.ModBlockEntities;
import net.blockpainter.newadventures.creativetabs.ModCreativeTabs;
import net.blockpainter.newadventures.entity.ModEntities;
import net.blockpainter.newadventures.entity.client.ModBoatRenderer;
import net.blockpainter.newadventures.util.ModWoodTypes;
import net.blockpainter.newadventures.items.ModItems;
import net.blockpainter.newadventures.worldgen.biome.ModRegionDesert;
import net.blockpainter.newadventures.worldgen.biome.ModSurfaceRuleData;
import net.blockpainter.newadventures.worldgen.biome.ModTerrablender;
import net.blockpainter.newadventures.worldgen.tree.ModFoliagePlacers;
import net.blockpainter.newadventures.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NewAdventures.MODID)
public class NewAdventures {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "newadventures";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "new_adventures_1_20_1" namespace
    public NewAdventures() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        ModTerrablender.registerBiomes();

        ModTrunkPlacerTypes.TRUNK_PLACER.register(modEventBus);
        ModFoliagePlacers.FOLIAGE_PLACERS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        LOGGER.info("HELLO FROM COMMON SETUP");

        event.enqueueWork(() ->
        {
            Regions.register(new ModRegionDesert(new ResourceLocation(MODID, "overworld_1"), 20));

            SurfaceRules.RuleSource combined = SurfaceRules.sequence(
                    ModSurfaceRuleData.makerules(), // dein Wüstenbiom
                    SurfaceRuleManager.getDefaultSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD)
            );

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, combined);
        });
        
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.YIRA);

            EntityRenderers.register(ModEntities.YIRA_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.YIRA_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
        }
    }
}
