package net.blockpainter.newadventures.worldgen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.worldgen.carver.ModCarvers;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class ModConfiguredCarvers {
    public static final ResourceKey<ConfiguredWorldCarver<?>> LARGE_LAKE_KEY = ResourceKey.create(
            Registries.CONFIGURED_CARVER, new ResourceLocation(NewAdventures.MODID, "large_lake"));

    public static void bootstrap(BootstapContext<ConfiguredWorldCarver<?>> context) {

        HolderGetter<Block> blocks = context.lookup(BuiltInRegistries.BLOCK.key());

        HolderSet<Block> replaceable = HolderSet.direct(
                blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, new ResourceLocation("minecraft", "sand"))),
                blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, new ResourceLocation("minecraft", "sandstone"))),
                blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, new ResourceLocation("minecraft", "red_sand"))),
                blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, new ResourceLocation("minecraft", "red_sandstone")))
        );


        CaveCarverConfiguration lakeConfig = new CaveCarverConfiguration(
                0.5F,
                UniformHeight.of(VerticalAnchor.absolute(32), VerticalAnchor.absolute(80)), // height range
                ConstantFloat.of(0.8F),
                VerticalAnchor.absolute(128), // max vertical scale
                CarverDebugSettings.DEFAULT,
                replaceable,
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
