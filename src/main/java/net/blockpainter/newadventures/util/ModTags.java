package net.blockpainter.newadventures.util;

import net.blockpainter.newadventures.NewAdventures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class BLocks {

        public static final  TagKey<Block> YIRA_DIRT = createTag("yira_dirt");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, name));
        }
    }

}
