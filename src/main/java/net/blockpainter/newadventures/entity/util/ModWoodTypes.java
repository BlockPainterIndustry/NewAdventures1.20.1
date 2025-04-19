package net.blockpainter.newadventures.entity.util;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType PINE = WoodType.register(new WoodType(NewAdventures.MODID + ":yira", ModBlocks.YIRA_BLOCKSETTYPE));
}