package net.cxncentrate.tutorialmod;

import com.mojang.brigadier.Command;
import net.cxncentrate.tutorialmod.block.ModBlocks;
import net.cxncentrate.tutorialmod.item.ModItemGroups;
import net.cxncentrate.tutorialmod.item.ModItems;
import net.cxncentrate.tutorialmod.painting.ModPaintings;
import net.cxncentrate.tutorialmod.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
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