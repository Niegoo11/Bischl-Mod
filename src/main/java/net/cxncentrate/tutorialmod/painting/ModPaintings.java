package net.cxncentrate.tutorialmod.painting;

import net.cxncentrate.tutorialmod.TutorialMod;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {

    public static final PaintingVariant B_1 = registerPainting("b_1", new PaintingVariant(128, 72));
    public static final PaintingVariant B_2 = registerPainting("b_2", new PaintingVariant(54, 96));


    private static PaintingVariant registerPainting(String name, PaintingVariant variant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(TutorialMod.MOD_ID, name), variant);
    }

    public static void registerPaintings() {
        TutorialMod.LOGGER.info("Registering Paintings for " + TutorialMod.MOD_ID);
    }

}
