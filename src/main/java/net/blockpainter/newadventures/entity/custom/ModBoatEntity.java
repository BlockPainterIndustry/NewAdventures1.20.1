package net.blockpainter.newadventures.entity.custom;

import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.entity.ModEntities;
import net.blockpainter.newadventures.items.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.IntFunction;

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModBoatEntity.class, EntityDataSerializers.INT);

    public ModBoatEntity(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    public ModBoatEntity(Level level, double x, double y, double z) {
        this(ModEntities.YIRA_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public Item getDropItem() {
        return getModVariant().getItem().get();
    }

    public void setVariant(Type type) {
        this.entityData.set(DATA_ID_TYPE, type.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, 0); // default to first enum entry
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("Type", getModVariant().getSerializedName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("Type", Tag.TAG_STRING)) {
            setVariant(Type.byName(tag.getString("Type")));
        }
    }

    public enum Type implements StringRepresentable {
        YIRA(ModBlocks.YIRA_PLANKS.get(), ModItems.YIRA_BOAT, "yira"),
        PALME(ModBlocks.PALME_PLANKS.get(), ModItems.PALME_BOAT, "palme");

        private final String name;
        private final Block planks;
        private final RegistryObject<Item> item;

        public static final EnumCodec<Type> CODEC = StringRepresentable.fromEnum(Type::values);
        private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        Type(Block planks, RegistryObject<Item> item, String name) {
            this.name = name;
            this.planks = planks;
            this.item = item;
        }

        public String getSerializedName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public RegistryObject<Item> getItem() {
            return this.item;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public static Type byId(int id) {
            return BY_ID.apply(id);
        }

        public static Type byName(String name) {
            return CODEC.byName(name, YIRA);
        }

        public String getName() {
            return this.name;
        }
    }
}

