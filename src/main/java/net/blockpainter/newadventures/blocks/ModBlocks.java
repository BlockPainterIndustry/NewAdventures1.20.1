package net.blockpainter.newadventures.blocks;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.custom.*;
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

    public static final WoodType YIRA_WOODTYPE = WoodType.register(new WoodType("yira", BlockSetType.register(YIRA_BLOCKSETTYPE)));

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NewAdventures.MODID);

    //Yira Wood
    public static final RegistryObject<Block> YIRA_LOG = registerBlock("yira_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> YIRA_WOOD = registerBlock("yira_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_YIRA_LOG = registerBlock("stripped_yira_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_YIRA_WOOD = registerBlock("stripped_yira_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public  static  final RegistryObject<Block> YIRA_PLANKS = registerBlock("yira_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {

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
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS))
    );

    public static final RegistryObject<Block> YIRA_SLAB = registerBlock("yira_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB))
    );

    public static final RegistryObject<Block> YIRA_DOOR = registerBlock("yira_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(), BlockSetType.register(YIRA_BLOCKSETTYPE))

    );
    public static final RegistryObject<Block> YIRA_TRAPDOOR = registerBlock("yira_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().noOcclusion(), BlockSetType.register(YIRA_BLOCKSETTYPE))
    );

    public static final RegistryObject<Block> YIRA_PRESSURE_PLATE = registerBlock("yira_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.register(YIRA_BLOCKSETTYPE))
    );

    public static final RegistryObject<Block> YIRA_BUTTON = registerBlock("yira_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.register(YIRA_BLOCKSETTYPE), 10, true)
    );

    public static final RegistryObject<Block> YIRA_FENCE = registerBlock("yira_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE))
    );

    public static final RegistryObject<Block> YIRA_FENCE_GATE = registerBlock("yira_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.register(YIRA_WOODTYPE))
    );

    public static final RegistryObject<Block> YIRA_SIGN = BLOCKS.register("yira_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.YIRA));
    public static final RegistryObject<Block> YIRA_WALL_SIGN = BLOCKS.register("yira_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.YIRA));

    public static final RegistryObject<Block> YIRA_HANGING_SIGN = BLOCKS.register("yira_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.YIRA));
    public static final RegistryObject<Block> YIRA_WALL_HANGING_SIGN = BLOCKS.register("yira_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.YIRA));

    public static final RegistryObject<Block> YIRA_GRASS_BLOCK = registerBlock("yira_grass_block",
            () -> new ModGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> YIRA_DIRT = registerBlock("yira_dirt",
            () -> new ModDirt(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> YIRA_FARMLAND = registerBlock("yira_farmland",
            () -> new ModFarmlandBlock(BlockBehaviour.Properties.copy(Blocks.FARMLAND)));

    public static final RegistryObject<Block> YIRA_SAPLING_CROP = BLOCKS.register("yira_sapling_croap",
            () -> new ModSaplingCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    public static final RegistryObject<Block> YIRA_LEAVES = registerBlock("yira_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
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
            () -> new ShearableLeaveBlock(BlockBehaviour.Properties.copy(YIRA_LEAVES.get()), YIRA_LEAVES.get()
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

    public static final RegistryObject<Block> GRAY_SAND = registerBlock("gray_sand",
            () -> new SandBlock(3582982, BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> GRAY_SANDSTONE = registerBlock("gray_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> GRAY_SANDSTONE_STAIRS = registerBlock("gray_sandstone_stairs",
            () -> new StairBlock(ModBlocks.GRAY_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS)));
    public static final RegistryObject<Block> GRAY_SANDSTONE_SLAB = registerBlock("gray_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB)));
    public static final RegistryObject<Block> GRAY_SANDSTONE_WALL = registerBlock("gray_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL)));
    public static final RegistryObject<Block> GRAY_CHISELED_SANDSTONE = registerBlock("gray_chiseled_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_SANDSTONE)));

    public static final RegistryObject<Block> GRAY_SMOOTH_SANDSTONE = registerBlock("gray_smooth_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE)));
    public static final RegistryObject<Block> GRAY_SMOOTH_SANDSTONE_STAIRS = registerBlock("gray_smooth_sandstone_stairs",
            () -> new StairBlock(ModBlocks.GRAY_SMOOTH_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_STAIRS)));
    public static final RegistryObject<Block> GRAY_SMOOTH_SANDSTONE_SLAB = registerBlock("gray_smooth_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_SLAB)));

    public static final RegistryObject<Block> GRAY_CUT_SANDSTONE = registerBlock("gray_cut_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE)));
    public static final RegistryObject<Block> GRAY_CUT_SANDSTONE_SLAB = registerBlock("gray_cut_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_SLAB)));



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}