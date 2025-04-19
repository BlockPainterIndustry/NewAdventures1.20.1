package net.blockpainter.newadventures.blocks.entity;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NewAdventures.MODID);


    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> YIRA_SIGN =
            BLOCK_ENTITIES.register("yira_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.YIRA_SIGN.get(), ModBlocks.YIRA_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> YIRA_HANGING_SIGN =
            BLOCK_ENTITIES.register("yira_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            ModBlocks.YIRA_HANGING_SIGN.get(), ModBlocks.YIRA_WALL_HANGING_SIGN.get()).build(null));


}

