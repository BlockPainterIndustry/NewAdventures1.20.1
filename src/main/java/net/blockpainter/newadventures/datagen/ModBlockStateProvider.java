package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.blocks.custom.*;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NewAdventures.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        logBlock(((RotatedPillarBlock) ModBlocks.YIRA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.YIRA_WOOD.get()), blockTexture(ModBlocks.YIRA_LOG.get()), blockTexture(ModBlocks.YIRA_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_YIRA_LOG.get()), blockTexture(ModBlocks.STRIPPED_YIRA_LOG.get()),
                new ResourceLocation(NewAdventures.MODID, "block/stripped_yira_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_YIRA_WOOD.get()), blockTexture(ModBlocks.STRIPPED_YIRA_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_YIRA_LOG.get()));

        //yiraGrassBlock(ModBlocks.YIRA_GRASS_BLOCK);


        cubeBottomTopWithAlt(ModBlocks.YIRA_GRASS_BLOCK,
                "yira_dirt",
                "yira_grass_block_side",
                "yira_grass_block_top"
        );

        blockItem(ModBlocks.YIRA_LOG);
        blockItem(ModBlocks.YIRA_WOOD);
        blockItem(ModBlocks.STRIPPED_YIRA_LOG);
        blockItem(ModBlocks.STRIPPED_YIRA_WOOD);
        blockItem(ModBlocks.YIRA_GRASS_BLOCK);

        blockWithItem(ModBlocks.YIRA_PLANKS);
        blockWithItem(ModBlocks.YIRA_DIRT);

        farmlandBlock(ModBlocks.YIRA_FARMLAND.get());

        stairsBlock(((StairBlock) ModBlocks.YIRA_STAIRS.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.YIRA_SLAB.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.YIRA_BUTTON.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.YIRA_PRESSURE_PLATE.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.YIRA_FENCE.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.YIRA_FENCE_GATE.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.YIRA_DOOR.get()), modLoc("block/yira_door_bottom"), modLoc("block/yira_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.YIRA_TRAPDOOR.get()), modLoc("block/yira_trapdoor"), true, "cutout");

        signBlock(((StandingSignBlock) ModBlocks.YIRA_SIGN.get()), ((WallSignBlock) ModBlocks.YIRA_WALL_SIGN.get()),
                blockTexture(ModBlocks.YIRA_PLANKS.get()));

        hangingSignBlock(ModBlocks.YIRA_HANGING_SIGN.get(), ModBlocks.YIRA_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.YIRA_PLANKS.get()));
        saplingBlock(ModBlocks.YIRA_SAPLING);

        tallPlant(ModBlocks.YIRA_TALL_GRASS.get(), "yira_tall_grass");

        makeSingleCropBlock(((ModCropBlock) ModBlocks.YIRA_SAPLING_CROP.get()), "yira_sapling_crop_stage", "yira_sapling_crop_stage");

        saplingBlock(ModBlocks.YIRA_SHORT_GRASS);
        saplingBlock(ModBlocks.BLOODROSE);
        saplingBlock(ModBlocks.WATERCORN);
        saplingBlock(ModBlocks.VILE_FLOWER);


        leavesBlock(ModBlocks.YIRA_LEAVES);
        leavesBlock(ModBlocks.FLOWERING_YiRA_LEAVES);
        cactusLikeBlock(ModBlocks.RED_CACTUS.get());
        blockItem(ModBlocks.RED_CACTUS);

        blockWithItem(ModBlocks.GRAY_SAND);

        cubeBottomTop(ModBlocks.GRAY_SANDSTONE);
        modWetStairBottomTop(ModBlocks.GRAY_SANDSTONE_STAIRS, "gray_sandstone_bottom", "gray_sandstone", "gray_sandstone_top");
        modWetSlabBottomTop(ModBlocks.GRAY_SANDSTONE_SLAB, "gray_sandstone_slab", "gray_sandstone_bottom", "gray_sandstone", "gray_sandstone_top");
        wallBlock((ModWetWallBlock) ModBlocks.GRAY_SANDSTONE_WALL.get(), blockTexture(ModBlocks.GRAY_SANDSTONE.get()));

        cubeColumnWithAlt(ModBlocks.CHISELED_GRAY_SANDSTONE, "gray_sandstone_top", "chiseled_gray_sandstone");

        cubeAllWithOtherTexture(ModBlocks.SMOOTH_GRAY_SANDSTONE, "gray_sandstone_top");
        stairsBlock((ModWetStairBlock) ModBlocks.SMOOTH_GRAY_SANDSTONE_STAIRS.get(),"gray_sandstone_top");
        modWetSlabBottomTop(ModBlocks.SMOOTH_GRAY_SANDSTONE_SLAB, "smooth_gray_sandstone_slab", "gray_sandstone_top", "gray_sandstone_top", "gray_sandstone_top");

        cubeColumnWithAlt(ModBlocks.CUT_GRAY_SANDSTONE, "gray_sandstone_top", "cut_gray_sandstone");
        modWetSlabBottomTop(ModBlocks.CUT_GRAY_SANDSTONE_SLAB, "cut_gray_sandstone_slab", "gray_sandstone_top", "cut_gray_sandstone", "gray_sandstone_top");

        blockItem(ModBlocks.GRAY_SANDSTONE);
        blockItem(ModBlocks.CHISELED_GRAY_SANDSTONE);
        blockItem(ModBlocks.SMOOTH_GRAY_SANDSTONE);
        blockItem(ModBlocks.CUT_GRAY_SANDSTONE);

        blockWithItem(ModBlocks.WET_SAND);

        cubeBottomTop(ModBlocks.WET_SANDSTONE);
        modWetStairBottomTop(ModBlocks.WET_SANDSTONE_STAIRS, "wet_sandstone_bottom", "wet_sandstone", "wet_sandstone_top");
        modWetSlabBottomTop(ModBlocks.WET_SANDSTONE_SLAB, "wet_sandstone_slab", "wet_sandstone_bottom", "wet_sandstone", "wet_sandstone_top");
        wallBlock((ModWetWallBlock) ModBlocks.WET_SANDSTONE_WALL.get(), blockTexture(ModBlocks.WET_SANDSTONE.get()));

        cubeColumnWithAlt(ModBlocks.CHISELED_WET_SANDSTONE, "wet_sandstone_top", "chiseled_wet_sandstone");

        cubeAllWithOtherTexture(ModBlocks.SMOOTH_WET_SANDSTONE, "wet_sandstone_top");
        stairsBlock((ModWetStairBlock) ModBlocks.SMOOTH_WET_SANDSTONE_STAIRS.get(), "wet_sandstone_top");
        modWetSlabBottomTop(ModBlocks.SMOOTH_WET_SANDSTONE_SLAB, "smooth_wet_sandstone_slab", "wet_sandstone_top", "wet_sandstone_top", "wet_sandstone_top");

        cubeColumnWithAlt(ModBlocks.CUT_WET_SANDSTONE, "wet_sandstone_top", "cut_wet_sandstone");
        modWetSlabBottomTop(ModBlocks.CUT_WET_SANDSTONE_SLAB, "cut_wet_sandstone_slab", "wet_sandstone_top", "cut_wet_sandstone", "wet_sandstone_top");

        blockItem(ModBlocks.WET_SANDSTONE);
        blockItem(ModBlocks.CHISELED_WET_SANDSTONE);
        blockItem(ModBlocks.SMOOTH_WET_SANDSTONE);
        blockItem(ModBlocks.CUT_WET_SANDSTONE);

        blockWithItem(ModBlocks.WET_GRAY_SAND);

        cubeBottomTop(ModBlocks.WET_GRAY_SANDSTONE);
        modWetStairBottomTop(ModBlocks.WET_GRAY_SANDSTONE_STAIRS, "wet_gray_sandstone_bottom", "wet_gray_sandstone", "wet_gray_sandstone_top");
        modWetSlabBottomTop(ModBlocks.WET_GRAY_SANDSTONE_SLAB, "wet_gray_sandstone_slab", "wet_gray_sandstone_bottom", "wet_gray_sandstone", "wet_gray_sandstone_top");
        wallBlock((ModWetWallBlock) ModBlocks.WET_GRAY_SANDSTONE_WALL.get(), blockTexture(ModBlocks.WET_GRAY_SANDSTONE.get()));

        cubeColumnWithAlt(ModBlocks.CHISELED_WET_GRAY_SANDSTONE, "wet_gray_sandstone_top", "chiseled_wet_gray_sandstone");

        cubeAllWithOtherTexture(ModBlocks.SMOOTH_WET_GRAY_SANDSTONE, "wet_gray_sandstone_top");
        stairsBlock((ModWetStairBlock) ModBlocks.SMOOTH_WET_GRAY_SANDSTONE_STAIRS.get(),  "wet_gray_sandstone_top");
        modWetSlabBottomTop(ModBlocks.SMOOTH_WET_GRAY_SANDSTONE_SLAB, "smooth_wet_gray_sandstone_slab", "wet_gray_sandstone_top", "wet_gray_sandstone_top", "wet_gray_sandstone_top");

        cubeColumnWithAlt(ModBlocks.CUT_WET_GRAY_SANDSTONE, "wet_gray_sandstone_top", "cut_wet_gray_sandstone");
        modWetSlabBottomTop(ModBlocks.CUT_WET_GRAY_SANDSTONE_SLAB, "cut_wet_gray_sandstone_slab", "wet_gray_sandstone_top", "cut_wet_gray_sandstone", "wet_gray_sandstone_top");

        blockItem(ModBlocks.WET_GRAY_SANDSTONE);
        blockItem(ModBlocks.CHISELED_WET_GRAY_SANDSTONE);
        blockItem(ModBlocks.SMOOTH_WET_GRAY_SANDSTONE);
        blockItem(ModBlocks.CUT_WET_GRAY_SANDSTONE);

        blockWithItem(ModBlocks.WET_RED_SAND);

        cubeBottomTop(ModBlocks.WET_RED_SANDSTONE);
        modWetStairBottomTop(ModBlocks.WET_RED_SANDSTONE_STAIRS, "wet_red_sandstone_bottom", "wet_red_sandstone", "wet_red_sandstone_top");
        modWetSlabBottomTop(ModBlocks.WET_RED_SANDSTONE_SLAB, "wet_red_sandstone_slab", "wet_red_sandstone_bottom", "wet_red_sandstone", "wet_red_sandstone_top");
        wallBlock((ModWetWallBlock) ModBlocks.WET_RED_SANDSTONE_WALL.get(), blockTexture(ModBlocks.WET_RED_SANDSTONE.get()));

        cubeColumnWithAlt(ModBlocks.CHISELED_WET_RED_SANDSTONE, "wet_red_sandstone_top", "chiseled_wet_red_sandstone");

        cubeAllWithOtherTexture(ModBlocks.SMOOTH_WET_RED_SANDSTONE, "wet_red_sandstone_top");
        stairsBlock((ModWetStairBlock) ModBlocks.SMOOTH_WET_RED_SANDSTONE_STAIRS.get(),  "wet_red_sandstone_top");
        modWetSlabBottomTop(ModBlocks.SMOOTH_WET_RED_SANDSTONE_SLAB, "smooth_wet_red_sandstone_slab", "wet_red_sandstone_top", "wet_red_sandstone_top", "wet_red_sandstone_top");

        cubeColumnWithAlt(ModBlocks.CUT_WET_RED_SANDSTONE, "wet_red_sandstone_top", "cut_wet_red_sandstone");
        modWetSlabBottomTop(ModBlocks.CUT_WET_RED_SANDSTONE_SLAB, "cut_wet_red_sandstone_slab", "wet_sandstone_top", "cut_wet_red_sandstone", "wet_red_sandstone_top");

        blockItem(ModBlocks.WET_RED_SANDSTONE);
        blockItem(ModBlocks.CHISELED_WET_RED_SANDSTONE);
        blockItem(ModBlocks.SMOOTH_WET_RED_SANDSTONE);
        blockItem(ModBlocks.CUT_WET_RED_SANDSTONE);


    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));

    }

    private void tallPlant(Block block, String name) {
        getVariantBuilder(block).partialState()
                .with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER)
                .modelForState()
                .modelFile(models().cross(name + "_bottom", modLoc("block/" + name + "_bottom")).renderType("cutout")).addModel()

                .partialState()
                .with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER)
                .modelForState()
                .modelFile(models().cross(name + "_top", modLoc("block/" + name + "_top")).renderType("cutout")).addModel();
    }


    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation( "minecraft", "leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(NewAdventures.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void cubeBottomTopWithAlt(RegistryObject<Block> blockRegistryObject, String bottom, String side, String top) {
        simpleBlock(blockRegistryObject.get(), models().cubeBottomTop(
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                new ResourceLocation(NewAdventures.MODID, "block/" + side),
                new ResourceLocation(NewAdventures.MODID, "block/" + bottom),
                new ResourceLocation(NewAdventures.MODID, "block/" + top)
        ));
    }

    private void cubeBottomTop(RegistryObject<Block> blockRegistryObject) {
        String name = ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath();
        simpleBlock(blockRegistryObject.get(), models().cubeBottomTop(
                name,
                new ResourceLocation(NewAdventures.MODID, "block/" + name),
                new ResourceLocation(NewAdventures.MODID, "block/" + name + "_bottom"),
                new ResourceLocation(NewAdventures.MODID, "block/" + name + "_top")
        ));
    }

    private void cubeColumnWithAlt(RegistryObject<Block> blockRegistryObject, String end, String side) {
        simpleBlock(blockRegistryObject.get(), models().cubeColumn(
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                new ResourceLocation(NewAdventures.MODID, "block/" + side),
                new ResourceLocation(NewAdventures.MODID, "block/" + end)

        ));
    }

    private void cubeColumn(RegistryObject<Block> block) {
        String name = ForgeRegistries.BLOCKS.getKey(block.get()).getPath();
        simpleBlock(block.get(), models().cubeColumn(
                        name,
                        new ResourceLocation(NewAdventures.MODID, "block/" + name),
                        new ResourceLocation(NewAdventures.MODID, "block/" + name + "_top")
                )
        );
    }

    private void stairBottomTop(RegistryObject<Block> blockRegistryObject, String bottom, String side, String top) {
        String name = ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath();
        if (name.endsWith("_stairs")) {
            name = name.substring(0, name.length() - "_stairs".length());
        }

        stairsBlock((StairBlock) blockRegistryObject.get(),
                name,
                new ResourceLocation(NewAdventures.MODID, "block/" + side),
                new ResourceLocation(NewAdventures.MODID, "block/" + bottom),
                new ResourceLocation(NewAdventures.MODID, "block/" + top)
        );
    }

    private void modWetStairBottomTop(RegistryObject<Block> blockRegistryObject, String bottom, String side, String top) {
        String name = ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath();
        if (name.endsWith("_stairs")) {
            name = name.substring(0, name.length() - "_stairs".length());
        }

        stairsBlock((ModWetStairBlock) blockRegistryObject.get(),
                side,
                bottom,
                top
        );
    }




    private void slabBottomTop(RegistryObject<Block> blockRegistryObject, String key, String bottom, String side, String top) {
        slabBlock((SlabBlock) blockRegistryObject.get(),
               new ResourceLocation(NewAdventures.MODID, key + "_top"),
               new ResourceLocation(NewAdventures.MODID, "block/" + side),
               new ResourceLocation(NewAdventures.MODID, "block/" + bottom),
               new ResourceLocation(NewAdventures.MODID, "block/" + top)
       );

    }

    private void modWetSlabBottomTop(RegistryObject<Block> obj, String key, String bottom, String side, String top) {
        Block block = obj.get();
        // Erzeuge die drei Modelle (bottom, top, double) über models().slab(...) und slabTop(...):
        ModelFile bottomModel = models().slab(key,
                modLoc("block/" + side),
                modLoc("block/" + bottom),
                modLoc("block/" + top));
        ModelFile topModel = models().slabTop(key + "_top",
                modLoc("block/" + side),
                modLoc("block/" + bottom),
                modLoc("block/" + top));
        ModelFile doubleModel = models().getExistingFile(modLoc("block/" + key + "_top"));

        // Baue die Blockstate-Variants ohne Cast auf SlabBlock:
        getVariantBuilder(block)
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM)
                .addModels(new ConfiguredModel(bottomModel))
                .partialState().with(SlabBlock.TYPE, SlabType.TOP)
                .addModels(new ConfiguredModel(topModel))
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE)
                .addModels(new ConfiguredModel(doubleModel));
    }

    private void cubeAllWithOtherTexture(RegistryObject<Block> blockRegistryObject, String all) {
        simpleBlock(blockRegistryObject.get(), models().cubeAll(
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                new ResourceLocation(NewAdventures.MODID, "block/" + all)
        ));
    }

    private void farmlandBlock(Block block) {

        ModelFile dryModel = models().withExistingParent("yira_farmland", mcLoc("block/template_farmland"))
                .texture("dirt", modLoc("block/yira_dirt"))
                .texture("top", modLoc("block/yira_farmland"));

        ModelFile moistModel = models().withExistingParent("yira_farmland_moist", mcLoc("block/template_farmland"))
                .texture("dirt", modLoc("block/yira_dirt"))
                .texture("top", modLoc("block/yira_farmland_moist"));

        getVariantBuilder(block)
                .forAllStates(state -> {
                    int moisture = state.getValue(FarmBlock.MOISTURE);

                    ResourceLocation model = (moisture == 7) ? moistModel.getLocation() : dryModel.getLocation();

                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(model))
                            .build();
                });
    }

    public void makeSingleCropBlock(ModCropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> singleBlockCropStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] singleBlockCropStates(BlockState state, ModCropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ModSaplingCropBlock) block).getAgeProperty()),
                new ResourceLocation(NewAdventures.MODID, "block/" + textureName + state.getValue(((ModSaplingCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void cactusLikeBlock(Block block) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();
        ResourceLocation resourceLocation = new ResourceLocation(NewAdventures.MODID, "block/red_cactus");

        // Modell erstellen
        models().withExistingParent(name, mcLoc("block/block"))
                .texture("bottom", resourceLocation + "_bottom")
                .texture("particle", resourceLocation + "_side")
                .texture("top", resourceLocation + "_top")
                .texture("side", resourceLocation + "_side")
                .element()
                .from(0, 0, 0)
                .to(16, 16, 16)
                .face(Direction.DOWN)
                .uvs(0, 0, 16, 16)
                .texture("#bottom")
                .cullface(Direction.DOWN)
                .end()
                .face(Direction.UP)
                .uvs(0, 0, 16, 16)
                .texture("#top")
                .cullface(Direction.UP)
                .end()
                .end()
                .element()
                .from(0, 0, 1)
                .to(16, 16, 15)
                .face(Direction.NORTH)
                .uvs(0, 0, 16, 16)
                .texture("#side")
                .end()
                .face(Direction.SOUTH)
                .uvs(0, 0, 16, 16)
                .texture("#side")
                .end()
                .end()
                .element()
                .from(1, 0, 0)
                .to(15, 16, 16)
                .face(Direction.WEST)
                .uvs(0, 0, 16, 16)
                .texture("#side")
                .end()
                .face(Direction.EAST)
                .uvs(0, 0, 16, 16)
                .texture("#side")
                .end()
                .end();

        // Blockstate-Datei erstellen (einfacher Blockstate für dein Cactus-Block)
        simpleBlock(block, models().getExistingFile(resourceLocation));
    }

    public void stairsBlock(ModWetStairBlock block, String texture) {
        stairsBlock(block, texture, texture, texture);
    }
    private void stairsBlock(ModWetStairBlock block, String side, String bottom, String top) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();
        ModelFile model = models().stairs(name,
                modLoc("block/" + side),
                modLoc("block/" + bottom),
                modLoc("block/" + top));
        simpleBlock(block, model);
    }

    public void slabBlock(ModWetSlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
        slabBlock(block, doubleslab, texture, texture, texture);
    }

    public void slabBlock(ModWetSlabBlock block, ResourceLocation doubleslab, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        slabBlock(block, models().slab(name(block), side, bottom, top), models().slabTop(name(block) + "_top", side, bottom, top), models().getExistingFile(doubleslab));
    }

    public void slabBlock(ModWetSlabBlock block, ModelFile bottom, ModelFile top, ModelFile doubleslab) {
        getVariantBuilder(block)
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel(bottom))
                .partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel(top))
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel(doubleslab));
    }

    public void wallBlock(ModWetWallBlock block, ResourceLocation texture) {
        wallBlockInternal(block, name(block), texture);
    }

    public void wallBlock(ModWetWallBlock block, String name, ResourceLocation texture) {
        wallBlockInternal(block, name + "_wall", texture);
    }

    private void wallBlockInternal(ModWetWallBlock block, String baseName, ResourceLocation texture) {
        modWetWallBlock(block, models().wallPost(baseName + "_post", texture),
                models().wallSide(baseName + "_side", texture),
                models().wallSideTall(baseName + "_side_tall", texture));
    }

    public void modWetWallBlock(ModWetWallBlock block, ModelFile post, ModelFile side, ModelFile sideTall) {
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block)
                .part().modelFile(post).addModel()
                .condition(WallBlock.UP, true).end();
        WALL_PROPS.entrySet().stream()
                .filter(e -> e.getKey().getAxis().isHorizontal())
                .forEach(e -> {
                    wallSidePart(builder, side, e, WallSide.LOW);
                    wallSidePart(builder, sideTall, e, WallSide.TALL);
                });
    }

    private void wallSidePart(MultiPartBlockStateBuilder builder, ModelFile model, Map.Entry<Direction, Property<WallSide>> entry, WallSide height) {
        builder.part()
                .modelFile(model)
                .rotationY((((int) entry.getKey().toYRot()) + 180) % 360)
                .uvLock(true)
                .addModel()
                .condition(entry.getValue(), height);
    }


}
