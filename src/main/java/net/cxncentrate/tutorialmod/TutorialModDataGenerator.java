package net.cxncentrate.tutorialmod;

import net.cxncentrate.tutorialmod.datagen.ModBlockTagProvider;
import net.cxncentrate.tutorialmod.datagen.ModItemTagProvider;
import net.cxncentrate.tutorialmod.datagen.ModLootTableProvider;
import net.cxncentrate.tutorialmod.datagen.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TutorialModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);

	}
}