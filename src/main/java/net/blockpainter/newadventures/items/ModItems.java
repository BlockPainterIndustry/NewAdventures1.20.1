package net.blockpainter.newadventures.items;

import net.blockpainter.newadventures.NewAdventures;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NewAdventures.MODID);

    public static final RegistryObject<Item> SCROLL = ITEMS.register("scroll",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)
            ));
    public static final RegistryObject<Item> YIRA_BOAT = ITEMS.register("yira_boat",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
            ));
    public static final RegistryObject<Item> YIRA_CHEST_BOAT = ITEMS.register("yira_chest_boat",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
            ));

    /*public static final RegistryObject<Item> YIRA_BOAT = ITEMS.register("yira_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.YIRA, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_boat")))));
    public static final RegistryObject<Item> YIRA_CHEST_BOAT = ITEMS.register("yira_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.YIRA, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_chest_boat")))));*/




}
