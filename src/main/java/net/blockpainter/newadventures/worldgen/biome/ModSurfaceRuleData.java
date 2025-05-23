package net.blockpainter.newadventures.worldgen.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class ModSurfaceRuleData {

    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }



    public static SurfaceRules.RuleSource makerules() {
        return SurfaceRules.ifTrue(
                SurfaceRules.isBiome(ModBiomes.DESERT_OASIS),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(
                                SurfaceRules.stoneDepthCheck(0, false, 5, CaveSurface.FLOOR),
                                SurfaceRules.state(Blocks.SAND.defaultBlockState())
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.stoneDepthCheck(0, false, 15, CaveSurface.FLOOR),
                                SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState())
                        )
                )
        );
    }
}
