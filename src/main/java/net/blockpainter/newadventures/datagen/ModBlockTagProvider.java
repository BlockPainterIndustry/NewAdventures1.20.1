package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
    }
}