package net.blockpainter.newadventures.items.custom;

import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;

public class ModFloweringBranchItem extends Item{

    public static final int GRASS_SPREAD_WIDTH = 3;
    public static final int GRASS_SPREAD_HEIGHT = 1;
    public static final int GRASS_COUNT_MULTIPLIER = 3;

    public ModFloweringBranchItem(Item.Properties p_40626_) {
        super(p_40626_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos origin = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (!(level instanceof ServerLevel serverLevel)) return InteractionResult.PASS;

        RandomSource random = level.getRandom();
        boolean success = false;

        int radius = 5;
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -radius; z <= radius; z++) {

                    if (x * x + z * z > radius * radius) continue;

                    mutablePos.set(origin.offset(x, y, z));

                    BlockState current = level.getBlockState(mutablePos);
                    BlockPos abovePos = mutablePos.above();
                    BlockState above = level.getBlockState(abovePos);

                    boolean isReplaceableBase = current.is(Blocks.GRASS_BLOCK) || current.is(Blocks.DIRT) || current.is(Blocks.COARSE_DIRT);
                    boolean isTallGrass = (above.is(Blocks.TALL_GRASS) || above.is(Blocks.LARGE_FERN)) && (current.is(Blocks.GRASS_BLOCK) || current.is(Blocks.DIRT) || current.is(Blocks.COARSE_DIRT ));
                    boolean isSurfacePlant = above.is(Blocks.GRASS) || above.is(Blocks.FERN);

                    BlockState lower = ModBlocks.YIRA_TALL_GRASS.get().defaultBlockState()
                            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);

                    BlockState upper = ModBlocks.YIRA_TALL_GRASS.get().defaultBlockState()
                            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);

                    if (isTallGrass) {
                        level.setBlock(mutablePos, ModBlocks.YIRA_GRASS_BLOCK.get().defaultBlockState(), 3);
                        level.setBlock(abovePos, lower, 3);
                        level.setBlock(abovePos.above(), upper, 3);
                        success = true;
                        continue;
                    }
                    if (isReplaceableBase && (above.isAir() || isSurfacePlant)) {
                        if (isSurfacePlant) {
                            level.destroyBlock(abovePos, false);
                        }

                        level.setBlock(mutablePos, ModBlocks.YIRA_GRASS_BLOCK.get().defaultBlockState(), 3);
                        success = true;
                        BlockState toPlace = null;
                        boolean tallGrassPlaced = false;
                        if (random.nextFloat() < 0.5F) {
                            switch (random.nextInt(5)) {
                                case 0 -> toPlace = ModBlocks.VILE_FLOWER.get().defaultBlockState();
                                case 1 -> toPlace = ModBlocks.WATERCORN.get().defaultBlockState();
                                case 2 -> toPlace = ModBlocks.BLOODROSE.get().defaultBlockState();
                                case 3 -> {

                                    if (level.getBlockState(abovePos).isAir() && level.getBlockState(abovePos.above()).isAir()) {
                                        level.setBlock(abovePos, ModBlocks.YIRA_TALL_GRASS.get().defaultBlockState()
                                                .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 3);

                                        level.setBlock(abovePos.above(), ModBlocks.YIRA_TALL_GRASS.get().defaultBlockState()
                                                .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER), 3);
                                        tallGrassPlaced = true;
                                    }
                                }
                                default -> toPlace = ModBlocks.YIRA_SHORT_GRASS.get().defaultBlockState();
                            }
                            if (toPlace != null && !tallGrassPlaced) {
                                level.setBlock(abovePos, toPlace, 3);
                            }
                        }
                    }
                }
            }
        }

        if (success) {
            level.levelEvent(1505, origin, 0);
            if (!player.isCreative()) stack.shrink(1);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }
}
