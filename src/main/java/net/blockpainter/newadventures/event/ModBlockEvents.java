package net.blockpainter.newadventures.event;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.server.ServerLifecycleHooks;

@Mod.EventBusSubscriber(modid = NewAdventures.MODID)
public class ModBlockEvents {

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server == null) return;

        for (ServerLevel level : server.getAllLevels()) {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                BlockPos center = player.blockPosition();
                BlockPos.betweenClosed(center.offset(-16, -4, -16), center.offset(16, 4, 16)).forEach(pos -> {
                    BlockState state = level.getBlockState(pos);
                    Block block = state.getBlock();

                    if (state.is(ModTags.BLocks.DRY_SAND) && isNearWater(level, pos)) {
                        Block wetVariant = getWetVersion(block);
                        if (wetVariant != null) {
                            level.setBlock(pos, wetVariant.defaultBlockState(), Block.UPDATE_ALL);
                        }
                    }

                    if (state.is(ModTags.BLocks. WET_SAND) && isExposedToSunOrHeat(level, pos) && !isNearWater(level, pos)) {
                        Block dryVariant = getDryVersion(block);
                        if (dryVariant != null) {
                            level.setBlock(pos, dryVariant.defaultBlockState(), Block.UPDATE_ALL);
                        }
                    }
                });
            }
        }
    }

    private static Block getDryVersion(Block block) {
        ResourceLocation registryName = ForgeRegistries.BLOCKS.getKey(block);
        if (registryName == null) return null;

        if (registryName.getPath().contains("wet_gray")) {
            String dryPath = registryName.getPath().replace("wet_", "");
            ResourceLocation dryId = new ResourceLocation(NewAdventures.MODID, dryPath);
            return ForgeRegistries.BLOCKS.getValue(dryId);
        } else if (registryName.getPath().contains("wet_sand")) {
            String dryPath = registryName.getPath().replace("wet_", "");
            ResourceLocation dryId = new ResourceLocation("minecraft", dryPath);
            return ForgeRegistries.BLOCKS.getValue(dryId);
        } else if (registryName.getPath().contains("wet_red")) {
            String dryPath = registryName.getPath().replace("wet_", "");
            ResourceLocation dryId = new ResourceLocation("minecraft", dryPath);
            return ForgeRegistries.BLOCKS.getValue(dryId);
        } else {
            return null;
        }
    }

    private static boolean isExposedToSunOrHeat(Level level, BlockPos pos) {
        if (level.canSeeSky(pos.above()) && level.getBrightness(LightLayer.SKY, pos.above()) >= 15) {
            return true;
        }
        for (Direction direction : Direction.values()) {
            BlockPos adjacentPos = pos.relative(direction);

            if (level.getBrightness(LightLayer.BLOCK, adjacentPos) >= 10) {
                return true;
            }
        }
        return false;
    }


    private static boolean isNearWater(Level level, BlockPos pos) {
        for (Direction dir : Direction.values()) {
            if (level.getFluidState(pos.relative(dir)).is(FluidTags.WATER)) {
                return true;
            }
        }
        return false;
    }

    public static Block getWetVersion(Block block) {
        ResourceLocation registryName = ForgeRegistries.BLOCKS.getKey(block);
        if (registryName == null) return null;

        if (registryName.getPath().contains("gray") && !registryName.getPath().contains("wet_")) {
            String wetPath = registryName.getPath().replace("gray_", "wet_gray_");
            ResourceLocation wetId = new ResourceLocation(NewAdventures.MODID, wetPath);
            return ForgeRegistries.BLOCKS.getValue(wetId);
        } else if (registryName.getPath().contains("sand") && !registryName.getPath().contains("wet_") && !registryName.getPath().contains("red_") && !registryName.getPath().contains("gray_")) {
            String wetPath = registryName.getPath().replace("sand", "wet_sand");
            ResourceLocation wetId = new ResourceLocation(NewAdventures.MODID, wetPath);
            return ForgeRegistries.BLOCKS.getValue(wetId);
        } else if (registryName.getPath().contains("red") && !registryName.getPath().contains("wet_")) {
            String wetPath = registryName.getPath().replace("red_", "wet_red_");
            ResourceLocation wetId = new ResourceLocation(NewAdventures.MODID, wetPath);
            return ForgeRegistries.BLOCKS.getValue(wetId);
        } else {
            return null;
        }
    }
}

