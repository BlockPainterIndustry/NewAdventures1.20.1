package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NewAdventures.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SCROLL);
        simpleItem(ModItems.YIRA_BOAT);
        simpleItem(ModItems.YIRA_CHEST_BOAT);
        simpleItem(ModItems.FLOWERING_YIRA_BRANCH);
        simpleItem(ModItems.YIRA_SAPLING_SEEDS);


        fenceItem(ModBlocks.YIRA_FENCE, ModBlocks.YIRA_PLANKS);
        buttonItem(ModBlocks.YIRA_BUTTON, ModBlocks.YIRA_PLANKS);

        evenSimplerBlockItem(ModBlocks.YIRA_STAIRS);
        evenSimplerBlockItem(ModBlocks.YIRA_SLAB);
        evenSimplerBlockItem(ModBlocks.YIRA_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.YIRA_FENCE_GATE);
        simpleBlockItem(ModBlocks.YIRA_DOOR);
        trapdoorItem(ModBlocks.YIRA_TRAPDOOR);

        evenSimplerBlockItem(ModBlocks.YIRA_FARMLAND);

        simpleItem(ModItems.YIRA_SIGN);
        simpleItem(ModItems.YIRA_HANGING_SIGN);
        saplingItem(ModBlocks.YIRA_SAPLING);
        saplingItem(ModBlocks.YIRA_SHORT_GRASS);
        saplingItem(ModBlocks.BLOODROSE);
        saplingItem(ModBlocks.WATERCORN);
        saplingItem(ModBlocks.VILE_FLOWER);

        tallgrass(ModBlocks.YIRA_TALL_GRASS);

        basicItem(ModItems.GOBLIN_GOLD_INGOT.get());

        basicItem(ModItems.CURSE_SMITHING_TEMPALTE.get());
        basicItem(ModItems.SHAPE_SMITHING_TEMPALTE.get());
        basicItem(ModItems.BLIND_SMITHING_TEMPALTE.get());

        evenSimplerBlockItem(ModBlocks.GRAY_SANDSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.GRAY_SANDSTONE_SLAB);
        wallItem(ModBlocks.GRAY_SANDSTONE_WALL, ModBlocks.GRAY_SANDSTONE);
        evenSimplerBlockItem(ModBlocks.SMOOTH_GRAY_SANDSTONE_SLAB);
        evenSimplerBlockItem(ModBlocks.SMOOTH_GRAY_SANDSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CUT_GRAY_SANDSTONE_SLAB);

        evenSimplerBlockItem(ModBlocks.WET_SANDSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.WET_SANDSTONE_SLAB);
        wallItem(ModBlocks.WET_SANDSTONE_WALL, ModBlocks.WET_SANDSTONE);
        evenSimplerBlockItem(ModBlocks.SMOOTH_WET_SANDSTONE_SLAB);
        evenSimplerBlockItem(ModBlocks.SMOOTH_WET_SANDSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CUT_WET_SANDSTONE_SLAB);

        evenSimplerBlockItem(ModBlocks.WET_GRAY_SANDSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.WET_GRAY_SANDSTONE_SLAB);
        wallItem(ModBlocks.WET_GRAY_SANDSTONE_WALL, ModBlocks.WET_GRAY_SANDSTONE);
        evenSimplerBlockItem(ModBlocks.SMOOTH_WET_GRAY_SANDSTONE_SLAB);
        evenSimplerBlockItem(ModBlocks.SMOOTH_WET_GRAY_SANDSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CUT_WET_GRAY_SANDSTONE_SLAB);

        evenSimplerBlockItem(ModBlocks.WET_RED_SANDSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.WET_RED_SANDSTONE_SLAB);
        wallItem(ModBlocks.WET_RED_SANDSTONE_WALL, ModBlocks.WET_RED_SANDSTONE);
        evenSimplerBlockItem(ModBlocks.SMOOTH_WET_RED_SANDSTONE_SLAB);
        evenSimplerBlockItem(ModBlocks.SMOOTH_WET_RED_SANDSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CUT_WET_RED_SANDSTONE_SLAB);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NewAdventures.MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NewAdventures.MODID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(NewAdventures.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",   new ResourceLocation(NewAdventures.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(NewAdventures.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(NewAdventures.MODID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NewAdventures.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder tallgrass(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NewAdventures.MODID,"block/" + item.getId().getPath() + "_top"));
    }
}
