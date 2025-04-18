package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

        blockItem(ModBlocks.YIRA_LOG);
        blockItem(ModBlocks.YIRA_WOOD);
        blockItem(ModBlocks.STRIPPED_YIRA_LOG);
        blockItem(ModBlocks.STRIPPED_YIRA_WOOD);

        blockWithItem(ModBlocks.YIRA_PLANKS);


        stairsBlock(((StairBlock) ModBlocks.YIRA_STAIRS.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.YIRA_SLAB.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.YIRA_BUTTON.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.YIRA_PRESSURE_PLATE.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.YIRA_FENCE.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.YIRA_FENCE_GATE.get()), blockTexture(ModBlocks.YIRA_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.YIRA_DOOR.get()), modLoc("block/yira_door_bottom"), modLoc("block/yira_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.YIRA_TRAPDOOR.get()), modLoc("block/yira_trapdoor"), true, "cutout");





        leavesBlock(ModBlocks.YIRA_LEAVES);

        /*signBlock(((StandingSignBlock) ModBlocks.PINE_SIGN.get()), ((WallSignBlock) ModBlocks.PINE_WALL_SIGN.get()),
                blockTexture(ModBlocks.PINE_PLANKS.get()));

        hangingSignBlock(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.PINE_PLANKS.get()));*/
        saplingBlock(ModBlocks.YIRA_SAPLING);

    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
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
}
