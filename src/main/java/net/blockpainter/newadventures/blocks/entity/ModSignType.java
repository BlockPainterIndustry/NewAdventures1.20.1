package net.blockpainter.newadventures.blocks.entity;

import net.blockpainter.newadventures.util.ModWoodTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.registries.RegistryObject;

public enum ModSignType {
    YIRA(ModBlockEntities.YIRA_SIGN, ModBlockEntities.YIRA_HANGING_SIGN, ModWoodTypes.YIRA),
    PALME(ModBlockEntities.PALME_SIGN, ModBlockEntities.PALME_HANGING_SIGN, ModWoodTypes.PALME);

    private final RegistryObject<BlockEntityType<ModSignBlockEntity>> standingBlockEntityType;
    private final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> hangingBlockEntityType;
    private final WoodType woodType;

    ModSignType(
            RegistryObject<BlockEntityType<ModSignBlockEntity>> standingBlockEntityType,
            RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> hangingBlockEntityType,
            WoodType woodType
    ) {
        this.standingBlockEntityType = standingBlockEntityType;
        this.hangingBlockEntityType = hangingBlockEntityType;
        this.woodType = woodType;
    }

    public RegistryObject<BlockEntityType<ModSignBlockEntity>> blockEntityType() {
        return standingBlockEntityType;
    }

    public RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> hangingBlockEntityType() {
        return hangingBlockEntityType;
    }

    public WoodType woodType() {
        return woodType;
    }
}

