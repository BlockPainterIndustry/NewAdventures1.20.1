package net.blockpainter.newadventures.blocks.custom;

import net.blockpainter.newadventures.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.RandomSequence;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ShearableLeaveBlock extends LeavesBlock {

    private final Block replacementBlock;
    public ShearableLeaveBlock(Properties properties, Block replacementBlock) {
        super(properties);
        this.replacementBlock = replacementBlock;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {

        ItemStack heldItem = player.getItemInHand(hand);
        if (heldItem.getItem() instanceof ShearsItem) {
            if (!level.isClientSide) {
                level.playSound(null, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlock(pos, replacementBlock.defaultBlockState().setValue(PERSISTENT, true), 3);
                Block.popResource(level, pos, new ItemStack(ModItems.FLOWERING_YIRA_BRANCH.get()));
                if(RandomSource.create().nextFloat() < 0.2f) {
                    Block.popResource(level, pos, new ItemStack(ModItems.YIRA_SAPLING_SEEDS.get()));
                }

                player.getItemInHand(hand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
