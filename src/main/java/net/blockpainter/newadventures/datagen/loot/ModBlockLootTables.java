package net.blockpainter.newadventures.datagen.loot;

import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.items.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.YIRA_LOG.get());
        this.dropSelf(ModBlocks.YIRA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_YIRA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_YIRA_WOOD.get());
        this.dropSelf(ModBlocks.YIRA_PLANKS.get());
        this.dropSelf(ModBlocks.YIRA_DIRT.get());
        this.add(ModBlocks.YIRA_GRASS_BLOCK.get(), block -> createSingleItemTableWithSilkTouch(ModBlocks.YIRA_GRASS_BLOCK.get(), ModBlocks.YIRA_DIRT.get()));

        this.dropSelf(ModBlocks.YIRA_STAIRS.get());
        this.dropSelf(ModBlocks.YIRA_BUTTON.get());
        this.dropSelf(ModBlocks.YIRA_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.YIRA_TRAPDOOR.get());
        this.dropSelf(ModBlocks.YIRA_FENCE.get());
        this.dropSelf(ModBlocks.YIRA_FENCE_GATE.get());

        this.add(ModBlocks.YIRA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.YIRA_SLAB.get()));
        this.add(ModBlocks.YIRA_DOOR.get(),
                block -> createDoorTable(ModBlocks.YIRA_DOOR.get()));




        this.add(ModBlocks.YIRA_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.YIRA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.FLOWERING_YiRA_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.YIRA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.YIRA_SIGN.get(), block ->
                createSingleItemTable(ModItems.YIRA_SIGN.get()));
        this.add(ModBlocks.YIRA_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.YIRA_SIGN.get()));
        this.add(ModBlocks.YIRA_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.YIRA_HANGING_SIGN.get()));
        this.add(ModBlocks.YIRA_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.YIRA_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.YIRA_SAPLING.get());

        this.dropSelf(ModBlocks.BLOODROSE.get());
        this.dropSelf(ModBlocks.VILE_FLOWER.get());
        this.dropSelf(ModBlocks.WATERCORN.get());

        this.dropWhenSilkTouch(ModBlocks.YIRA_TALL_GRASS.get());
        this.dropWhenSilkTouch(ModBlocks.YIRA_SHORT_GRASS.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
