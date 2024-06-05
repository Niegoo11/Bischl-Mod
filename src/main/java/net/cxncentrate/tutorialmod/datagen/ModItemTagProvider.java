package net.cxncentrate.tutorialmod.datagen;

import net.cxncentrate.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.BE_MUSIC_DISC)
                .add(ModItems.FIGURE_09_MUSIC_DISC)
                .add(ModItems.COG_MUSIC_DISC);

        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.BE_MUSIC_DISC)
                .add(ModItems.FIGURE_09_MUSIC_DISC)
                .add(ModItems.COG_MUSIC_DISC);
    }
}
