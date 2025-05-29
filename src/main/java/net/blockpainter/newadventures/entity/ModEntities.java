package net.blockpainter.newadventures.entity;

import net.blockpainter.newadventures.NewAdventures;

import net.blockpainter.newadventures.entity.custom.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NewAdventures.MODID);

    public static final RegistryObject<EntityType<ModBoatEntity>> YIRA_BOAT =
            ENTITY_TYPES.register("yira_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("yira_boat"));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> YIRA_CHEST_BOAT =
            ENTITY_TYPES.register("yira_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("yira_chest_boat"));

    public static final RegistryObject<EntityType<ModBoatEntity>> PALEM_BOAT =
            ENTITY_TYPES.register("palme_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("palme_boat"));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> PALME_CHEST_BOAT =
            ENTITY_TYPES.register("palme_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("palme_chest_boat"));
}
