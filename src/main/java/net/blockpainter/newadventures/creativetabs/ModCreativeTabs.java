package net.blockpainter.newadventures.creativetabs;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NewAdventures.MODID);

    public static final RegistryObject<CreativeModeTab> NA_BIOME_TAB = CREATIVE_MODE_TAB.register("na_biome_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.YIRA_LOG.get()))
                    .title(Component.translatable("creativetab.newadventures.biome_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.YIRA_LOG.get());
                        output.accept(ModBlocks.STRIPPED_YIRA_LOG.get());
                        output.accept(ModBlocks.YIRA_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_YIRA_WOOD.get());
                        output.accept(ModBlocks.YIRA_PLANKS.get());
                        output.accept(ModBlocks.YIRA_STAIRS.get());
                        output.accept(ModBlocks.YIRA_SLAB.get());
                        output.accept(ModBlocks.YIRA_DOOR.get());
                        output.accept(ModBlocks.YIRA_TRAPDOOR.get());
                        output.accept(ModBlocks.YIRA_FENCE.get());
                        output.accept(ModBlocks.YIRA_FENCE_GATE.get());
                        output.accept(ModBlocks.YIRA_SIGN.get());
                        output.accept(ModBlocks.YIRA_HANGING_SIGN.get());
                        output.accept(ModBlocks.YIRA_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.YIRA_BUTTON.get());
                        output.accept(ModItems.YIRA_BOAT.get());
                        output.accept(ModItems.YIRA_CHEST_BOAT.get());
                        output.accept(ModBlocks.YIRA_SAPLING.get());
                        output.accept(ModItems.YIRA_SAPLING_SEEDS.get());
                        output.accept(ModBlocks.YIRA_LEAVES.get());
                        output.accept(ModBlocks.FLOWERING_YiRA_LEAVES.get());
                        output.accept(ModItems.FLOWERING_YIRA_BRANCH.get());
                        output.accept(ModBlocks.YIRA_GRASS_BLOCK.get());
                        output.accept(ModBlocks.YIRA_DIRT.get());
                        output.accept(ModBlocks.YIRA_FARMLAND.get());
                        output.accept(ModBlocks.YIRA_SHORT_GRASS.get());
                        output.accept(ModBlocks.YIRA_TALL_GRASS.get().asItem());
                        output.accept(ModBlocks.BLOODROSE.get());
                        output.accept(ModBlocks.WATERCORN.get());
                        output.accept(ModBlocks.VILE_FLOWER.get());
                        output.accept(ModBlocks.GRAY_SAND.get());
                        output.accept(ModBlocks.GRAY_SANDSTONE.get());
                        output.accept(ModBlocks.GRAY_SANDSTONE_SLAB.get());
                        output.accept(ModBlocks.GRAY_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.GRAY_SANDSTONE_WALL.get());
                        output.accept(ModBlocks.GRAY_SANDSTONE.get());
                        output.accept(ModBlocks.SMOOTH_GRAY_SANDSTONE.get());
                        output.accept(ModBlocks.SMOOTH_GRAY_SANDSTONE_SLAB.get());
                        output.accept(ModBlocks.SMOOTH_GRAY_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.CUT_GRAY_SANDSTONE.get());
                        output.accept(ModBlocks.CUT_GRAY_SANDSTONE_SLAB.get());
                        output.accept(ModBlocks.PALME_LOG.get());
                        output.accept(ModBlocks.STRIPPED_PALME_LOG.get());
                        output.accept(ModBlocks.PALME_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_PALME_WOOD.get());
                        output.accept(ModBlocks.PALME_PLANKS.get());
                        output.accept(ModBlocks.PALME_STAIRS.get());
                        output.accept(ModBlocks.PALME_SLAB.get());
                        output.accept(ModBlocks.PALME_DOOR.get());
                        output.accept(ModBlocks.PALME_TRAPDOOR.get());
                        output.accept(ModBlocks.PALME_FENCE.get());
                        output.accept(ModBlocks.PALME_FENCE_GATE.get());
                        output.accept(ModBlocks.PALME_SIGN.get());
                        output.accept(ModBlocks.PALME_HANGING_SIGN.get());
                        output.accept(ModBlocks.PALME_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.PALME_BUTTON.get());
                        output.accept(ModItems.PALME_BOAT.get());
                        output.accept(ModItems.PALME_CHEST_BOAT.get());
                        output.accept(ModBlocks.PALME_SAPLING.get());
                        output.accept(ModBlocks.PALME_LEAVES.get());
                        output.accept(ModBlocks.RED_CACTUS.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> NA_ITEMS = CREATIVE_MODE_TAB.register("na_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GOBLIN_GOLD_INGOT.get()))
                    .title(Component.translatable("creativetab.newadventures.items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GOBLIN_GOLD_INGOT.get());
                        output.accept(ModItems.CURSE_SMITHING_TEMPALTE.get());
                        output.accept(ModItems.SHAPE_SMITHING_TEMPALTE.get());
                        output.accept(ModItems.BLIND_SMITHING_TEMPALTE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> NA_SCROLL_TAB = CREATIVE_MODE_TAB.register("na_scroll_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCROLL.get()))
                    .title(Component.translatable("creativetab.newadventures.scroll_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SCROLL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
