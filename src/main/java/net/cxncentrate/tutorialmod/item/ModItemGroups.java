package net.cxncentrate.tutorialmod.item;

import net.cxncentrate.tutorialmod.TutorialMod;
import net.cxncentrate.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(TutorialMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                        entries.add(ModItems.BE_MUSIC_DISC);
                        entries.add(ModItems.FIGURE_09_MUSIC_DISC);
                        entries.add(ModItems.COG_MUSIC_DISC);

                        entries.add(ModItems.METAL_DETECTOR);

                        entries.add(Items.DIAMOND);

                        entries.add(ModBlocks.RUBY_BLOCK);
                    }).build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
