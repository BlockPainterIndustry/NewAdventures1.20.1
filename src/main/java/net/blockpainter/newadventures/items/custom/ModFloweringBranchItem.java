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
import net.minecraft.world.level.block.BaseCoralWallFanBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
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

        // Ähnlich wie bei Moss: zufällig um den Block herum spreaden
        for (int i = 0; i < 64; ++i) {
            BlockPos targetPos = origin.offset(
                    random.nextInt(-GRASS_SPREAD_WIDTH, GRASS_SPREAD_WIDTH + 1),
                    random.nextInt(-GRASS_SPREAD_HEIGHT, GRASS_SPREAD_HEIGHT + 1),
                    random.nextInt(-GRASS_SPREAD_WIDTH, GRASS_SPREAD_WIDTH + 1)
            );

            BlockState targetState = level.getBlockState(targetPos);
            BlockState above = level.getBlockState(targetPos.above());

            if ((targetState.is(Blocks.GRASS_BLOCK) || targetState.is(Blocks.DIRT)) && above.isAir()) {
                level.setBlock(targetPos, ModBlocks.YIRA_GRASS_BLOCK.get().defaultBlockState(), 3);
                success = true;

                /*
                if (random.nextFloat() < 0.2F) {
                    level.setBlock(targetPos.above(), ModBlocks.YIRA_FLOWER.get().defaultBlockState(), 3);
                }*/
            }
        }

        if (success) {
            level.levelEvent(1505, origin, 0); // Partikel
            if (!player.isCreative()) stack.shrink(1);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }
}
