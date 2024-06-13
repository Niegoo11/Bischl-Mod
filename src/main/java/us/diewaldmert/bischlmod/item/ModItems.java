package us.diewaldmert.bischlmod.item;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.SpawnEggItem;
import us.diewaldmert.bischlmod.BischlMod;
import us.diewaldmert.bischlmod.entity.ModEntities;
import us.diewaldmert.bischlmod.item.custom.MetalDetectorItem;
import us.diewaldmert.bischlmod.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item BE_MUSIC_DISC = registerItem("be_music_disc", new MusicDiscItem(7, ModSounds.BE, new FabricItemSettings().maxCount(1), 233));
    public static final Item FIGURE_09_MUSIC_DISC = registerItem("figure_09_music_disc", new MusicDiscItem(7, ModSounds.FIGURE_09, new FabricItemSettings().maxCount(1), 194));
    public static final Item COG_MUSIC_DISC = registerItem("cog_music_disc", new MusicDiscItem(7, ModSounds.COG, new FabricItemSettings().maxCount(1), 205));

    public static final Item BISCHL_SPAWN_EGG = registerItem("bischl_spawn_egg",
            new SpawnEggItem(ModEntities.BISCHL, 0x696b7a, 0x696b7a, new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BischlMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BischlMod.LOGGER.info("Registering Mod Items for " + BischlMod.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
