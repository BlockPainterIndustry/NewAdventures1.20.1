package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.blocks.custom.ModSaplingCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
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
                ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "block/stripped_yira_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_YIRA_WOOD.get()), blockTexture(ModBlocks.STRIPPED_YIRA_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_YIRA_LOG.get()));

        //yiraGrassBlock(ModBlocks.YIRA_GRASS_BLOCK);


        cubeBottomTop(ModBlocks.YIRA_GRASS_BLOCK,
                ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "block/yira_dirt"),
                ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "block/yira_grass_block_side"),
                ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "block/yira_grass_block_top")
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


        tallPlant(ModBlocks.YIRA_TALL_GRASS.get(), "yira_tall_grass");

        makeCornCrop(((CropBlock) ModBlocks.YIRA_SAPLING_CROP.get()), "yira_sapling_crop_stage", "yira_sapling_crop_stage");

        saplingBlock(ModBlocks.YIRA_SHORT_GRASS);
        saplingBlock(ModBlocks.BLOODROSE);
        saplingBlock(ModBlocks.WATERCORN);
        saplingBlock(ModBlocks.VILE_FLOWER);


        leavesBlock(ModBlocks.YIRA_LEAVES);
        leavesBlock(ModBlocks.FLOWERING_YiRA_LEAVES);

        signBlock(((StandingSignBlock) ModBlocks.YIRA_SIGN.get()), ((WallSignBlock) ModBlocks.YIRA_WALL_SIGN.get()),
                blockTexture(ModBlocks.YIRA_PLANKS.get()));

        hangingSignBlock(ModBlocks.YIRA_HANGING_SIGN.get(), ModBlocks.YIRA_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.YIRA_PLANKS.get()));
        saplingBlock(ModBlocks.YIRA_SAPLING);

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
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.fromNamespaceAndPath( "minecraft", "leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(NewAdventures.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void cubeBottomTop(RegistryObject<Block> blockRegistryObject, ResourceLocation bottom, ResourceLocation side, ResourceLocation top) {
        simpleBlock(blockRegistryObject.get(), models().cubeBottomTop(
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                side,
                bottom,
                top
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

    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ModSaplingCropBlock) block).getAgeProperty()),
                 ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "block/" + textureName + state.getValue(((ModSaplingCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

}
