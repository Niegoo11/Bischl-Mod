package us.diewaldmert.bischlmod.sound;

import us.diewaldmert.bischlmod.BischlMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");

    public static final SoundEvent BE = registerSoundEvent("be");
    public static final SoundEvent FIGURE_09 = registerSoundEvent("figure_09");
    public static final SoundEvent COG = registerSoundEvent("cog");

    public static void registerSounds() {
        BischlMod.LOGGER.info("Registering Sounds for " + BischlMod.MOD_ID);
    }

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(BischlMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

}
