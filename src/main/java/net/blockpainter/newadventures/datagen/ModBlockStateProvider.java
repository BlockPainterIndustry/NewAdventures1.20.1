package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.blocks.custom.ModCropBlock;
import net.blockpainter.newadventures.blocks.custom.ModSaplingCropBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Properties;
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

        blockWithItem(ModBlocks.GRAY_SAND);

        cubeBottomTop(ModBlocks.GRAY_SANDSTONE);
        stairBottomTop(ModBlocks.GRAY_SANDSTONE_STAIRS, "gray_sandstone_bottom", "gray_sandstone", "gray_sandstone_top");
        slabBottomTop(ModBlocks.GRAY_SANDSTONE_SLAB, "gray_sandstone_slab", "gray_sandstone_bottom", "gray_sandstone", "gray_sandstone_top");
        wallBlock((WallBlock) ModBlocks.GRAY_SANDSTONE_WALL.get(), blockTexture(ModBlocks.GRAY_SANDSTONE.get()));

        cubeColumnWithAlt(ModBlocks.GRAY_CHISELED_SANDSTONE, "gray_sandstone_top", "gray_chiseled_sandstone");

        cubeAllWithOtherTexture(ModBlocks.GRAY_SMOOTH_SANDSTONE, "gray_sandstone_top");
        stairsBlock((StairBlock) ModBlocks.GRAY_SMOOTH_SANDSTONE_STAIRS.get(), new ResourceLocation(NewAdventures.MODID, "block/gray_sandstone_top"));
        slabBlock((SlabBlock) ModBlocks.GRAY_SMOOTH_SANDSTONE_SLAB.get(), blockTexture(ModBlocks.GRAY_SMOOTH_SANDSTONE.get()), new ResourceLocation(NewAdventures.MODID, "block/gray_sandstone_top"));

        cubeColumnWithAlt(ModBlocks.GRAY_CUT_SANDSTONE, "gray_sandstone_top", "gray_cut_sandstone");
        slabBottomTop(ModBlocks.GRAY_CUT_SANDSTONE_SLAB, "gray_cut_sandstone_slab", "gray_sandstone_top", "gray_cut_sandstone", "gray_sandstone_top");

        blockItem(ModBlocks.GRAY_SANDSTONE);
        blockItem(ModBlocks.GRAY_CHISELED_SANDSTONE);
        blockItem(ModBlocks.GRAY_SMOOTH_SANDSTONE);
        blockItem(ModBlocks.GRAY_CUT_SANDSTONE);

        cactusLikeBlock(ModBlocks.RED_CACTUS.get());
        blockItem(ModBlocks.RED_CACTUS);

        blockWithItem(ModBlocks.WET_SAND);

        cubeBottomTop(ModBlocks.WET_SANDSTONE);
        stairBottomTop(ModBlocks.WET_SANDSTONE_STAIRS, "wet_sandstone_bottom", "wet_sandstone", "wet_sandstone_top");
        slabBottomTop(ModBlocks.WET_SANDSTONE_SLAB, "wet_sandstone_slab", "wet_sandstone_bottom", "wet_sandstone", "wet_sandstone_top");
        wallBlock((WallBlock) ModBlocks.WET_SANDSTONE_WALL.get(), blockTexture(ModBlocks.WET_SANDSTONE.get()));

        cubeColumnWithAlt(ModBlocks.WET_CHISELED_SANDSTONE, "wet_sandstone_top", "wet_chiseled_sandstone");

        cubeAllWithOtherTexture(ModBlocks.WET_SMOOTH_SANDSTONE, "wet_sandstone_top");
        stairsBlock((StairBlock) ModBlocks.WET_SMOOTH_SANDSTONE_STAIRS.get(), new ResourceLocation(NewAdventures.MODID, "block/wet_sandstone_top"));
        slabBlock((SlabBlock) ModBlocks.WET_SMOOTH_SANDSTONE_SLAB.get(), blockTexture(ModBlocks.WET_SMOOTH_SANDSTONE.get()), new ResourceLocation(NewAdventures.MODID, "block/wet_sandstone_top"));

        cubeColumnWithAlt(ModBlocks.WET_CUT_SANDSTONE, "wet_sandstone_top", "wet_cut_sandstone");
        slabBottomTop(ModBlocks.WET_CUT_SANDSTONE_SLAB, "wet_cut_sandstone_slab", "wet_sandstone_top", "wet_cut_sandstone", "wet_sandstone_top");

        blockItem(ModBlocks.WET_SANDSTONE);
        blockItem(ModBlocks.WET_CHISELED_SANDSTONE);
        blockItem(ModBlocks.WET_SMOOTH_SANDSTONE);
        blockItem(ModBlocks.WET_CUT_SANDSTONE);
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

    private void slabBottomTop(RegistryObject<Block> blockRegistryObject, String key, String bottom, String side, String top) {
        slabBlock((SlabBlock) blockRegistryObject.get(),
               new ResourceLocation(NewAdventures.MODID, key + "_top"),
               new ResourceLocation(NewAdventures.MODID, "block/" + side),
               new ResourceLocation(NewAdventures.MODID, "block/" + bottom),
               new ResourceLocation(NewAdventures.MODID, "block/" + top)
       );

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
}
