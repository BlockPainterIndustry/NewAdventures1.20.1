package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NewAdventures.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(BlockTags.FENCES).add(ModBlocks.YIRA_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.YIRA_FENCE_GATE.get());


        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.YIRA_WOOD.get())
                .add(ModBlocks.YIRA_LOG.get())
                .add(ModBlocks.STRIPPED_YIRA_LOG.get())
                .add(ModBlocks.STRIPPED_YIRA_WOOD.get());
        this.tag(BlockTags.LOGS)
                .add(ModBlocks.YIRA_WOOD.get())
                .add(ModBlocks.YIRA_LOG.get())
                .add(ModBlocks.STRIPPED_YIRA_LOG.get())
                .add(ModBlocks.STRIPPED_YIRA_WOOD.get());
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.YIRA_PLANKS.get());

        this.tag(ModTags.BLocks.YIRA_DIRT)
                .add(ModBlocks.YIRA_DIRT.get())
                .add(ModBlocks.YIRA_GRASS_BLOCK.get())
                .add(ModBlocks.YIRA_FARMLAND.get());
        this.tag(ModTags.BLocks.YIRA_SOIL)
                .add(ModBlocks.YIRA_FARMLAND.get());

        this.tag(ModTags.BLocks.DRY_SAND)
                .add(Blocks.SAND)
                .add(Blocks.SANDSTONE)
                .add(Blocks.SANDSTONE_SLAB)
                .add(Blocks.SANDSTONE_STAIRS)
                .add(Blocks.SANDSTONE_WALL)
                .add(Blocks.SMOOTH_SANDSTONE)
                .add(Blocks.SMOOTH_SANDSTONE_SLAB)
                .add(Blocks.SMOOTH_SANDSTONE_STAIRS)
                .add(Blocks.CUT_SANDSTONE)
                .add(Blocks.CUT_SANDSTONE_SLAB)
                .add(Blocks.RED_SAND)
                .add(Blocks.RED_SANDSTONE)
                .add(Blocks.RED_SANDSTONE_SLAB)
                .add(Blocks.RED_SANDSTONE_STAIRS)
                .add(Blocks.RED_SANDSTONE_WALL)
                .add(Blocks.SMOOTH_RED_SANDSTONE)
                .add(Blocks.SMOOTH_RED_SANDSTONE_SLAB)
                .add(Blocks.SMOOTH_RED_SANDSTONE_STAIRS)
                .add(Blocks.CUT_RED_SANDSTONE)
                .add(Blocks.CUT_RED_SANDSTONE_SLAB)
                .add(ModBlocks.GRAY_SAND.get())
                .add(ModBlocks.GRAY_SANDSTONE.get())
                .add(ModBlocks.GRAY_SANDSTONE_SLAB.get())
                .add(ModBlocks.GRAY_SANDSTONE_STAIRS.get())
                .add(ModBlocks.GRAY_SANDSTONE_WALL.get())
                .add(ModBlocks.SMOOTH_GRAY_SANDSTONE.get())
                .add(ModBlocks.SMOOTH_GRAY_SANDSTONE_SLAB.get())
                .add(ModBlocks.SMOOTH_GRAY_SANDSTONE_STAIRS.get())
                .add(ModBlocks.CUT_GRAY_SANDSTONE.get())
                .add(ModBlocks.CUT_GRAY_SANDSTONE_SLAB.get());

        this.tag(ModTags.BLocks.WET_SAND)
                .add(ModBlocks.WET_SAND.get())
                .add(ModBlocks.WET_SANDSTONE.get())
                .add(ModBlocks.WET_SANDSTONE_SLAB.get())
                .add(ModBlocks.WET_SANDSTONE_STAIRS.get())
                .add(ModBlocks.WET_SANDSTONE_WALL.get())
                .add(ModBlocks.SMOOTH_WET_SANDSTONE.get())
                .add(ModBlocks.SMOOTH_WET_SANDSTONE_SLAB.get())
                .add(ModBlocks.SMOOTH_WET_SANDSTONE_STAIRS.get())
                .add(ModBlocks.CUT_WET_SANDSTONE.get())
                .add(ModBlocks.CUT_WET_SANDSTONE_SLAB.get())
                .add(ModBlocks.WET_RED_SAND.get())
                .add(ModBlocks.WET_RED_SANDSTONE.get())
                .add(ModBlocks.WET_RED_SANDSTONE_SLAB.get())
                .add(ModBlocks.WET_RED_SANDSTONE_STAIRS.get())
                .add(ModBlocks.WET_RED_SANDSTONE_WALL.get())
                .add(ModBlocks.SMOOTH_WET_RED_SANDSTONE.get())
                .add(ModBlocks.SMOOTH_WET_RED_SANDSTONE_SLAB.get())
                .add(ModBlocks.SMOOTH_WET_RED_SANDSTONE_STAIRS.get())
                .add(ModBlocks.CUT_WET_RED_SANDSTONE.get())
                .add(ModBlocks.CUT_WET_RED_SANDSTONE_SLAB.get())
                .add(ModBlocks.WET_GRAY_SAND.get())
                .add(ModBlocks.WET_GRAY_SANDSTONE.get())
                .add(ModBlocks.WET_GRAY_SANDSTONE_SLAB.get())
                .add(ModBlocks.WET_GRAY_SANDSTONE_STAIRS.get())
                .add(ModBlocks.WET_GRAY_SANDSTONE_WALL.get())
                .add(ModBlocks.SMOOTH_WET_GRAY_SANDSTONE.get())
                .add(ModBlocks.SMOOTH_WET_GRAY_SANDSTONE_SLAB.get())
                .add(ModBlocks.SMOOTH_WET_GRAY_SANDSTONE_STAIRS.get())
                .add(ModBlocks.CUT_WET_GRAY_SANDSTONE.get())
                .add(ModBlocks.CUT_WET_GRAY_SANDSTONE_SLAB.get());
    }
}