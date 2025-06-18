package net.blockpainter.newadventures.worldgen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.worldgen.carver.ModCarvers;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class ModConfiguredCarvers {
    public static final ResourceKey<ConfiguredWorldCarver<?>> LARGE_LAKE_KEY = ResourceKey.create(
            Registries.CONFIGURED_CARVER, new ResourceLocation(NewAdventures.MODID, "large_lake"));

    public static void bootstrap(BootstapContext<ConfiguredWorldCarver<?>> context) {

        HolderSet<Block> replaceableBlocks = context.lookup(Registries.BLOCK).getOrThrow(TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft", "stone_ore_replaceables")));

        CaveCarverConfiguration lakeConfig = new CaveCarverConfiguration(
                0.5F,
                UniformHeight.of(VerticalAnchor.absolute(32), VerticalAnchor.absolute(80)), // height range
                ConstantFloat.of(0.8F),
                VerticalAnchor.absolute(128), // max vertical scale
                CarverDebugSettings.DEFAULT,
                replaceableBlocks,
                UniformFloat.of(3.0F, 6.0F),
                UniformFloat.of(2.0F, 4.0F),
                UniformFloat.of(-1.0F, 1.0F)
        );

        context.register(
                LARGE_LAKE_KEY,
                new ConfiguredWorldCarver<>(ModCarvers.LARGE_LAKE_CARVER.get(), lakeConfig)
        );
    }
}
