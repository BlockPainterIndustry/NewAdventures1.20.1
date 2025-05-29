package net.blockpainter.newadventures.util;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {

    public static final WoodType YIRA = WoodType.register(new WoodType(NewAdventures.MODID + ":yira", BlockSetType.register(ModBlockSetTypes.YIRA_BLOCKSETTYPE)));
    //public static final WoodType YIRA = WoodType.register(new WoodType(":yira", BlockSetType.OAK));

    public static final WoodType PALME = WoodType.register(new WoodType(NewAdventures.MODID + ":palme", BlockSetType.register(ModBlockSetTypes.PALME_BLOCKSETTYPE)));

}