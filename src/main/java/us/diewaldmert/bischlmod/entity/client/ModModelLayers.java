package us.diewaldmert.bischlmod.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import us.diewaldmert.bischlmod.BischlMod;

public class ModModelLayers {

    public static final EntityModelLayer BISCHL =
            new EntityModelLayer(new Identifier(BischlMod.MOD_ID, "bischl"), "main");

}
