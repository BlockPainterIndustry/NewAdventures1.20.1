package net.blockpainter.newadventures.blocks.custom;

import net.blockpainter.newadventures.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModFlowerBlock extends ModBushBlock {

    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private final MobEffect suspiciousStewEffect;
    private final int effectDuration;

    private final java.util.function.Supplier<MobEffect> suspiciousStewEffectSupplier;

    public ModFlowerBlock(java.util.function.Supplier<MobEffect> effectSupplier, int p_53513_, BlockBehaviour.Properties properties) {
        super(properties);
        this.suspiciousStewEffect = null;
        this.suspiciousStewEffectSupplier = effectSupplier;
        this.effectDuration = p_53513_;
    }

    protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
        return p_51042_.is(ModTags.BLocks.YIRA_DIRT) /*|| p_51042_.is(Blocks.FARMLAND)*/;
    }

    public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
        Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    public MobEffect getSuspiciousEffect() {
        if (true) return this.suspiciousStewEffectSupplier.get();
        return this.suspiciousStewEffect;
    }

    public int getEffectDuration() {
        if (this.suspiciousStewEffect == null && !this.suspiciousStewEffectSupplier.get().isInstantenous()) return this.effectDuration * 20;
        return this.effectDuration;
    }
}
