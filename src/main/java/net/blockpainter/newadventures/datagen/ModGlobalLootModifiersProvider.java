package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, NewAdventures.MODID);
    }

    @Override
    protected void start() {
    }
}
