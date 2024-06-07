package us.diewaldmert.bischlmod;

import us.diewaldmert.bischlmod.block.ModBlocks;
import us.diewaldmert.bischlmod.item.ModItemGroups;
import us.diewaldmert.bischlmod.item.ModItems;
import us.diewaldmert.bischlmod.painting.ModPaintings;
import us.diewaldmert.bischlmod.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BischlMod implements ModInitializer {
	public static final String MOD_ID = "bischlmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();

		ModPaintings.registerPaintings();

	}
}