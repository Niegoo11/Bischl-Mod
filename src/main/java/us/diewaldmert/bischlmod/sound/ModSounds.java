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

    // Bischl

    public static final SoundEvent
            BISCHL_FALAFEL = registerSoundEvent("bischl_falafel"),
            BISCHL_OIDA = registerSoundEvent("bischl_oida"),
            BISCHL_MINE = registerSoundEvent("bischl_mine"),
            BISCHL_MORGEN = registerSoundEvent("bischl_morgen"),
            BISCHL_GUTEARBEIT = registerSoundEvent("bischl_gutearbeit"),
            BISCHL_GRATULATION = registerSoundEvent("bischl_gratulation"),
            BISCHL_GENAUSO = registerSoundEvent("bischl_genauso"),
            BISCHL_SAUGEIL = registerSoundEvent("bischl_saugeil"),
            BISCHL_SEHRGUT = registerSoundEvent("bischl_sehrgut");

    public static SoundEvent[] BISCHL_SOUNDS = new SoundEvent[]{BISCHL_FALAFEL, BISCHL_OIDA, BISCHL_MINE, BISCHL_MORGEN, BISCHL_GUTEARBEIT, BISCHL_GRATULATION, BISCHL_GENAUSO, BISCHL_SAUGEIL, BISCHL_SEHRGUT};

    // \Bischl

    public static SoundEvent pickRandomBischlSound() {
        return BISCHL_SOUNDS[random(0, 8)];
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void registerSounds() {
        BischlMod.LOGGER.info("Registering Sounds for " + BischlMod.MOD_ID);
    }

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(BischlMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


}
