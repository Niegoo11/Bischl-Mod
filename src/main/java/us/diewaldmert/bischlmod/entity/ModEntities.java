package us.diewaldmert.bischlmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import us.diewaldmert.bischlmod.BischlMod;
import us.diewaldmert.bischlmod.entity.custom.BischlEntity;

public class ModEntities {

    public static final EntityType<BischlEntity> BISCHL = Registry.register(Registries.ENTITY_TYPE, new Identifier(BischlMod.MOD_ID, "bischl"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BischlEntity::new).dimensions(EntityDimensions.fixed(0.7f, 2f)).build());

}
