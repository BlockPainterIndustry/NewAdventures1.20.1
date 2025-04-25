package net.blockpainter.newadventures.items.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.worldgen.biome.ModBiomes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.FillBiomeCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.chunk.*;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.Nullable;

import java.lang.ref.Reference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

                    Holder<Biome> biomeHolder = getBiomeHolder(ModBiomes.YIRA_BIOME, level.registryAccess());

                    setBiome(serverLevel, mutablePos, biomeHolder);

                    boolean isReplaceableBase = current.is(Blocks.GRASS_BLOCK) || current.is(Blocks.DIRT) || current.is(Blocks.COARSE_DIRT);
                    boolean isTallGrass = (above.is(Blocks.TALL_GRASS) || above.is(Blocks.LARGE_FERN)) && (current.is(Blocks.GRASS_BLOCK) || current.is(Blocks.DIRT) || current.is(Blocks.COARSE_DIRT ));
                    boolean isSurfacePlant = above.is(Blocks.GRASS) || above.is(Blocks.FERN);
                    boolean isFlower = above.is(BlockTags.FLOWERS);
                    boolean isShortGras = (above.is(Blocks.GRASS) || above.is(Blocks.FERN));



                    BlockState lower = ModBlocks.YIRA_TALL_GRASS.get().defaultBlockState()
                            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);

                    BlockState upper = ModBlocks.YIRA_TALL_GRASS.get().defaultBlockState()
                            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);

                    if (isFlower) {
                        level.setBlock(mutablePos, ModBlocks.YIRA_GRASS_BLOCK.get().defaultBlockState(), 3);
                        BlockState toPlace = null;
                        switch (random.nextInt(3)) {
                            case 0 -> toPlace = ModBlocks.BLOODROSE.get().defaultBlockState();
                            case 1 -> toPlace = ModBlocks.VILE_FLOWER.get().defaultBlockState();
                            case 2 -> toPlace = ModBlocks.WATERCORN.get().defaultBlockState();
                            default -> toPlace = Blocks.AIR.defaultBlockState();

                        }

                        level.setBlock(abovePos, toPlace, 3);
                        success = true;
                        continue;
                    }
                    if (isTallGrass) {
                        level.setBlock(mutablePos, ModBlocks.YIRA_GRASS_BLOCK.get().defaultBlockState(), 3);
                        level.setBlock(abovePos, lower, 3);
                        level.setBlock(abovePos.above(), upper, 3);
                        success = true;
                        continue;
                    }
                    if (isShortGras) {
                        level.setBlock(mutablePos, ModBlocks.YIRA_GRASS_BLOCK.get().defaultBlockState(), 3);
                        level.setBlock(abovePos, ModBlocks.YIRA_SHORT_GRASS.get().defaultBlockState(), 3);
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
                        if (random.nextFloat() < 0.3F) {
                            switch (random.nextInt(2)) {
                                case 1 -> {

                                    if (level.getBlockState(abovePos).isAir() && level.getBlockState(abovePos.above()).isAir()) {
                                        level.setBlock(abovePos, ModBlocks.YIRA_TALL_GRASS.get().defaultBlockState()
                                                .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 3);

                                        level.setBlock(abovePos.above(), ModBlocks.YIRA_TALL_GRASS.get().defaultBlockState()
                                                .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER), 3);
                                        tallGrassPlaced = true;
                                    }
                                }
                                case 2 -> toPlace = ModBlocks.YIRA_SHORT_GRASS.get().defaultBlockState();
                                default -> toPlace = Blocks.AIR.defaultBlockState();
                            }
                            if (toPlace != null && !tallGrassPlaced) {
                                level.setBlock(abovePos, toPlace, 3);
                            }
                        }

                        if (random.nextFloat() < 0.1F) {
                            switch (random.nextInt(5)) {
                                case 1 -> toPlace = ModBlocks.VILE_FLOWER.get().defaultBlockState();
                                case 2 -> toPlace = ModBlocks.WATERCORN.get().defaultBlockState();
                                case 3 -> toPlace = ModBlocks.BLOODROSE.get().defaultBlockState();
                                default -> toPlace = Blocks.AIR.defaultBlockState();
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


    @Deprecated
    private void setBiome(ServerLevel level, BlockPos pos, Holder<Biome> newBiome) {
        fill(level,
                pos.offset(new Vec3i(-2, -2, -2)),
                pos.offset(new Vec3i(2, 2, 2)),
                newBiome,
                new Predicate<Holder<Biome>>() {
            @Override
            public boolean test(Holder<Biome> biomeHolder) {
                return true;
            }
        });


    }

    private static int quantize(int p_261998_) {
        return QuartPos.toBlock(QuartPos.fromBlock(p_261998_));
    }

    private static BlockPos quantize(BlockPos p_262148_) {
        return new BlockPos(quantize(p_262148_.getX()), quantize(p_262148_.getY()), quantize(p_262148_.getZ()));
    }

    private static BiomeResolver makeResolver(ChunkAccess p_262698_, BoundingBox p_262622_, Holder<Biome> p_262705_, Predicate<Holder<Biome>> p_262695_) {
        return (p_262550_, p_262551_, p_262552_, p_262553_) -> {
            int i = QuartPos.toBlock(p_262550_);
            int j = QuartPos.toBlock(p_262551_);
            int k = QuartPos.toBlock(p_262552_);
            Holder<Biome> holder = p_262698_.getNoiseBiome(p_262550_, p_262551_, p_262552_);
            if (p_262622_.isInside(i, j, k) && p_262695_.test(holder)) {
                return p_262705_;
            } else {
                return holder;
            }
        };
    }

    private static void fill(ServerLevel serverlevel, BlockPos p_262651_, BlockPos p_262678_, Holder<Biome> p_262612_, Predicate<Holder<Biome>> p_262697_) {
        BlockPos blockpos = quantize(p_262651_);
        BlockPos blockpos1 = quantize(p_262678_);
        BoundingBox boundingbox = BoundingBox.fromCorners(blockpos, blockpos1);
        int i = boundingbox.getXSpan() * boundingbox.getYSpan() * boundingbox.getZSpan();



            List<ChunkAccess> list = new ArrayList<>();

            for(int k = SectionPos.blockToSectionCoord(boundingbox.minZ()); k <= SectionPos.blockToSectionCoord(boundingbox.maxZ()); ++k) {
                for(int l = SectionPos.blockToSectionCoord(boundingbox.minX()); l <= SectionPos.blockToSectionCoord(boundingbox.maxX()); ++l) {
                    ChunkAccess chunkaccess = serverlevel.getChunk(l, k, ChunkStatus.FULL, false);
                    if (chunkaccess == null) {
                        continue;
                    }

                    list.add(chunkaccess);
                }
            }



            for(ChunkAccess chunkaccess1 : list) {
                chunkaccess1.fillBiomesFromNoise(makeResolver( chunkaccess1, boundingbox, p_262612_, p_262697_), serverlevel.getChunkSource().randomState().sampler());
                chunkaccess1.setUnsaved(true);
            }

            serverlevel.getChunkSource().chunkMap.resendBiomesForChunks(list);



    }

    public static Holder<Biome> getBiomeHolder(ResourceKey<Biome> biomeKey, RegistryAccess access) {
        return access.registryOrThrow(Registries.BIOME)
                .getHolderOrThrow(biomeKey);
    }
}
