package net.blockpainter.newadventures;

import com.mojang.logging.LogUtils;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.creativetabs.ModCreativeTabs;
import net.blockpainter.newadventures.items.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NewAdventures.MODID)
public class NewAdventures {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "new_adventures_1_20_1";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "new_adventures_1_20_1" namespace

    public NewAdventures(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }
}
