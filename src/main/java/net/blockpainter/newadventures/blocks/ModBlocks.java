package net.blockpainter.newadventures.blocks;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
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

    public static final RegistryObject<StairBlock> YIRA_STAIRS = registerBlock("yira_stairs",
            () -> new StairBlock(ModBlocks.YIRA_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS))
    );

    public static final RegistryObject<SlabBlock> YIRA_SLAB = registerBlock("yira_slab",
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
    public static final RegistryObject<Block> YIRA_SAPLING = registerBlock("yira_sapling",
            () -> new ModSaplingBlock(ModTreeGrowers.YIRA, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion(), () -> Blocks.END_STONE));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private  static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, name)))));
    }




    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}