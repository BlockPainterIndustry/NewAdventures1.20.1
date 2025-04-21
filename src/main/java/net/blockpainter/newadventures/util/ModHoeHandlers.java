package net.blockpainter.newadventures.util;

import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ModHoeHandlers {

    public static InteractionResult useHoe(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();
        ItemStack tool = context.getItemInHand();

        // Nur Hoe verwenden
        if (!(tool.getItem() instanceof HoeItem)) {
            return InteractionResult.PASS;
        }

        // Wenn Block nicht yira_dirt ist → nix tun
        if (!state.is(ModTags.BLocks.YIRA_DIRT)) {
            return InteractionResult.PASS;
        }

        // Wenn Block schon yira_farmland ist → nix tun
        if (state.is(ModBlocks.YIRA_FARMLAND.get())) {
            return InteractionResult.PASS;
        }

        // Auf der Unterseite → kein Farmland
        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        }

        BlockPos above = pos.above();
        if (!level.getBlockState(above).isAir()) {
            return InteractionResult.PASS;
        }

        // Jetzt setzen wir Yira-Farmland
        if (!level.isClientSide) {
            level.setBlock(pos, ModBlocks.YIRA_FARMLAND.get().defaultBlockState(), 11);

            // Optional: Tool-Schaden
            tool.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(context.getHand()));

            // Optional: Sound
            level.playSound(null, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

}
