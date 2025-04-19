package net.blockpainter.newadventures.items;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.entity.custom.YiraBoatEntity;
import net.blockpainter.newadventures.items.custom.ModBoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
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
            () -> new ModBoatItem(false, YiraBoatEntity.Type.YIRA, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> YIRA_CHEST_BOAT = ITEMS.register("yira_chest_boat",
            () -> new ModBoatItem(true, YiraBoatEntity.Type.YIRA, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> FLOWERING_YIRA_BRANCH = ITEMS.register("flowering_yira_branch",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> YIRA_SIGN = ITEMS.register("yira_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.YIRA_SIGN.get(), ModBlocks.YIRA_WALL_SIGN.get()));
    public static final RegistryObject<Item> YIRA_HANGING_SIGN = ITEMS.register("yira_hanging_sign",
            () -> new HangingSignItem(ModBlocks.YIRA_HANGING_SIGN.get(), ModBlocks.YIRA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

}
