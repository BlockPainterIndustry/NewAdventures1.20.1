package net.blockpainter.newadventures.util;

import net.blockpainter.newadventures.NewAdventures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class BLocks {

        public static final  TagKey<Block> YIRA_DIRT = createTag("yira_dirt");

        public static final TagKey<Block> YIRA_SOIL = createTag("yira_soil");

        public static final TagKey<Block> DRY_SAND = createTag("dry_sand");

        public static final TagKey<Block> WET_SAND = createTag("wet_sand");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create( new ResourceLocation(NewAdventures.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> YIRA_LOG = createTag("yira_log");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(new ResourceLocation(NewAdventures.MODID, name));
        }
    }

}
