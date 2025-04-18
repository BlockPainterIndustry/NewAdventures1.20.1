package net.blockpainter.newadventures.worldgen.tree;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower YIRA = new TreeGrower(NewAdventures.MODID + ":yira",
            Optional.empty(), Optional.of(ModConfiguredFeatures.YIRA_KEY), Optional.empty());
}