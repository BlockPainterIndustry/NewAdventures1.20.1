package net.blockpainter.newadventures.blocks;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.custom.*;
import net.blockpainter.newadventures.blocks.entity.ModSignType;
import net.blockpainter.newadventures.util.ModWoodTypes;
import net.blockpainter.newadventures.items.ModItems;
import net.blockpainter.newadventures.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final BlockSetType YIRA_BLOCKSETTYPE = BlockSetType.register(new BlockSetType(
            "YIRA",
            true,
            SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE,
            SoundEvents.WOODEN_DOOR_OPEN,
            SoundEvents.WOODEN_TRAPDOOR_CLOSE,
            SoundEvents.WOODEN_TRAPDOOR_OPEN,
            SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.WOODEN_BUTTON_CLICK_OFF,
            SoundEvents.WOODEN_BUTTON_CLICK_ON));

    public static final BlockSetType PALME_BLOCKSETTYPE = BlockSetType.register(new BlockSetType(
            "PALME",
            true,
            SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE,
            SoundEvents.WOODEN_DOOR_OPEN,
            SoundEvents.WOODEN_TRAPDOOR_CLOSE,
            SoundEvents.WOODEN_TRAPDOOR_OPEN,
            SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.WOODEN_BUTTON_CLICK_OFF,
            SoundEvents.WOODEN_BUTTON_CLICK_ON));

    public static final WoodType YIRA_WOODTYPE = WoodType.register(new WoodType("yira", BlockSetType.register(YIRA_BLOCKSETTYPE)));

    public static final WoodType PALME_WOODTYPE = WoodType.register(new WoodType("palme", BlockSetType.register(YIRA_BLOCKSETTYPE)));

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NewAdventures.MODID);

    //Yira Wood
    public static final RegistryObject<Block> YIRA_LOG = registerBlock("yira_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2.0F)));
    public static final RegistryObject<Block> YIRA_WOOD = registerBlock("yira_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2.0F)));

    public static final RegistryObject<Block> STRIPPED_YIRA_LOG = registerBlock("stripped_yira_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(2.0F)));
    public static final RegistryObject<Block> STRIPPED_YIRA_WOOD = registerBlock("stripped_yira_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(2.0F)));

    public  static  final RegistryObject<Block> YIRA_PLANKS = registerBlock("yira_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F)) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> YIRA_STAIRS = registerBlock("yira_stairs",
            () -> new StairBlock(ModBlocks.YIRA_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).strength(2.0F, 3.0F))
    );

    public static final RegistryObject<Block> YIRA_SLAB = registerBlock("yira_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).strength(2.0F, 3.0F))
    );

    public static final RegistryObject<Block> YIRA_DOOR = registerBlock("yira_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion().strength(3.0F), BlockSetType.register(YIRA_BLOCKSETTYPE))

    );
    public static final RegistryObject<Block> YIRA_TRAPDOOR = registerBlock("yira_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().noOcclusion().strength(3.0F), BlockSetType.register(YIRA_BLOCKSETTYPE))
    );

    public static final RegistryObject<Block> YIRA_PRESSURE_PLATE = registerBlock("yira_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).strength(0.5F), BlockSetType.register(YIRA_BLOCKSETTYPE))
    );

    public static final RegistryObject<Block> YIRA_BUTTON = registerBlock("yira_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.register(YIRA_BLOCKSETTYPE), 10, true)
    );

    public static final RegistryObject<Block> YIRA_FENCE = registerBlock("yira_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).strength(2.0F, 3.0F))
    );

    public static final RegistryObject<Block> YIRA_FENCE_GATE = registerBlock("yira_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).strength(2.0F, 3.0F), WoodType.register(YIRA_WOODTYPE))
    );

    public static final RegistryObject<Block> YIRA_SIGN = BLOCKS.register("yira_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(1.0F), ModWoodTypes.YIRA, ModSignType.YIRA));
    public static final RegistryObject<Block> YIRA_WALL_SIGN = BLOCKS.register("yira_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).strength(1.0F), ModWoodTypes.YIRA, ModSignType.YIRA));

    public static final RegistryObject<Block> YIRA_HANGING_SIGN = BLOCKS.register("yira_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).strength(1.0F), ModWoodTypes.YIRA, ModSignType.YIRA));
    public static final RegistryObject<Block> YIRA_WALL_HANGING_SIGN = BLOCKS.register("yira_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0F), ModWoodTypes.YIRA, ModSignType.YIRA));

    public static final RegistryObject<Block> YIRA_GRASS_BLOCK = registerBlock("yira_grass_block",
            () -> new ModGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).strength(0.6F)));
    public static final RegistryObject<Block> YIRA_DIRT = registerBlock("yira_dirt",
            () -> new ModDirt(BlockBehaviour.Properties.copy(Blocks.DIRT).strength(0.5F)));

    public static final RegistryObject<Block> YIRA_FARMLAND = registerBlock("yira_farmland",
            () -> new ModFarmlandBlock(BlockBehaviour.Properties.copy(Blocks.FARMLAND).strength(0.6F)));

    public static final RegistryObject<Block> YIRA_SAPLING_CROP = BLOCKS.register("yira_sapling_croap",
            () -> new ModSaplingCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    public static final RegistryObject<Block> YIRA_LEAVES = registerBlock("yira_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F)
                    ) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> FLOWERING_YiRA_LEAVES = registerBlock("flowering_yira_leaves",
            () -> new ShearableLeaveBlock(BlockBehaviour.Properties.copy(YIRA_LEAVES.get()).strength(0.2F), YIRA_LEAVES.get()
            ) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> YIRA_SAPLING = registerBlock("yira_sapling",
            () -> new ModSaplingBlock(new ModTreeGrowers(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion(), ModBlocks.YIRA_GRASS_BLOCK));

    public static final RegistryObject<Block> BLOODROSE = registerBlock("bloodrose",
            () -> new ModFlowerBlock(() -> MobEffects.CONFUSION, 6 , BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion()));
    public static final RegistryObject<Block> WATERCORN = registerBlock("watercorn",
            () -> new ModFlowerBlock(() -> MobEffects.DAMAGE_RESISTANCE, 3 , BlockBehaviour.Properties.copy(Blocks.CORNFLOWER).noOcclusion()));
    public static final RegistryObject<Block> VILE_FLOWER = registerBlock("vile_flower",
            () -> new ModFlowerBlock(() -> MobEffects.JUMP, 9 , BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));

    public static final RegistryObject<Block> YIRA_SHORT_GRASS = registerBlock("yira_short_grass",
            () -> new ModShortGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> YIRA_TALL_GRASS = registerBlock("yira_tall_grass",
            () -> new ModTallGrassBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private  static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<Block> RED_CACTUS = registerBlock("red_cactus",
            () -> new ModCactusBlock(BlockBehaviour.Properties.copy(Blocks.CACTUS).strength(0.4F)));

    public static final RegistryObject<Block> GRAY_SAND = registerBlock("gray_sand",
            () -> new SandBlock(3582982, BlockBehaviour.Properties.copy(Blocks.SAND).strength(0.5F)));

    public static final RegistryObject<Block> GRAY_SANDSTONE = registerBlock("gray_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).strength(0.8F)));
    public static final RegistryObject<Block> GRAY_SANDSTONE_STAIRS = registerBlock("gray_sandstone_stairs",
            () -> new StairBlock(ModBlocks.GRAY_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).strength(0.8F)));
    public static final RegistryObject<Block> GRAY_SANDSTONE_SLAB = registerBlock("gray_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB).strength(0.8F)));
    public static final RegistryObject<Block> GRAY_SANDSTONE_WALL = registerBlock("gray_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL).strength(0.8F)));
    public static final RegistryObject<Block> CHISELED_GRAY_SANDSTONE = registerBlock("chiseled_gray_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_SANDSTONE).strength(0.8F)));

    public static final RegistryObject<Block> SMOOTH_GRAY_SANDSTONE = registerBlock("smooth_gray_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE).strength(0.8F)));
    public static final RegistryObject<Block> SMOOTH_GRAY_SANDSTONE_STAIRS = registerBlock("smooth_gray_sandstone_stairs",
            () -> new StairBlock(ModBlocks.SMOOTH_GRAY_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_STAIRS).strength(0.8F)));
    public static final RegistryObject<Block> SMOOTH_GRAY_SANDSTONE_SLAB = registerBlock("smooth_gray_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_SLAB).strength(0.8F)));

    public static final RegistryObject<Block> CUT_GRAY_SANDSTONE = registerBlock("cut_gray_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE).strength(0.8F)));
    public static final RegistryObject<Block> CUT_GRAY_SANDSTONE_SLAB = registerBlock("cut_gray_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_SLAB).strength(0.8F)));

    public static final RegistryObject<Block> PALME_LOG = registerBlock("palme_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2.0F)));
    public static final RegistryObject<Block> PALME_WOOD = registerBlock("palme_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2.0F)));

    public static final RegistryObject<Block> STRIPPED_PALME_LOG = registerBlock("stripped_palme_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(2.0F)));
    public static final RegistryObject<Block> STRIPPED_PALME_WOOD = registerBlock("stripped_palme_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(2.0F)));

    public  static  final RegistryObject<Block> PALME_PLANKS = registerBlock("palme_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F)) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> PALME_STAIRS = registerBlock("palme_stairs",
            () -> new StairBlock(ModBlocks.YIRA_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).strength(2.0F, 3.0F))
    );

    public static final RegistryObject<Block> PALME_SLAB = registerBlock("palme_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).strength(2.0F, 3.0F))
    );

    public static final RegistryObject<Block> PALME_DOOR = registerBlock("palme_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion().strength(3.0F), BlockSetType.register(PALME_BLOCKSETTYPE))

    );
    public static final RegistryObject<Block> PALME_TRAPDOOR = registerBlock("palme_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().noOcclusion().strength(3.0F), BlockSetType.register(PALME_BLOCKSETTYPE))
    );

    public static final RegistryObject<Block> PALME_PRESSURE_PLATE = registerBlock("palme_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).strength(0.5F), BlockSetType.register(PALME_BLOCKSETTYPE))
    );

    public static final RegistryObject<Block> PALME_BUTTON = registerBlock("palme_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.register(PALME_BLOCKSETTYPE), 10, true)
    );

    public static final RegistryObject<Block> PALME_FENCE = registerBlock("palme_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).strength(2.0F))
    );

    public static final RegistryObject<Block> PALME_FENCE_GATE = registerBlock("palme_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).strength(2.0F), WoodType.register(PALME_WOODTYPE))
    );

    public static final RegistryObject<Block> PALME_SIGN = BLOCKS.register("palme_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(1.0F), ModWoodTypes.PALME, ModSignType.PALME));
    public static final RegistryObject<Block> PALME_WALL_SIGN = BLOCKS.register("palme_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).strength(1.0F), ModWoodTypes.PALME, ModSignType.PALME));

    public static final RegistryObject<Block> PALME_HANGING_SIGN = BLOCKS.register("palme_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).strength(1.0F), ModWoodTypes.PALME, ModSignType.PALME));
    public static final RegistryObject<Block> PALME_WALL_HANGING_SIGN = BLOCKS.register("palme_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0F), ModWoodTypes.PALME, ModSignType.PALME));

    public static final RegistryObject<Block> PALME_LEAVES = registerBlock("palme_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F)
            ) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> PALME_SAPLING = registerBlock("palme_sapling",
            () -> new ModSaplingBlock(new ModTreeGrowers(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion(), ModBlocks.YIRA_GRASS_BLOCK));


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}