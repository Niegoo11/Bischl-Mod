package us.diewaldmert.bischlmod.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.StructureTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.Structure;

public class ModStructureFinder {

    public static BlockPos findStronghold(PlayerEntity p, BlockPos currentPos) {

        TagKey<Structure> strongholdTag = TagKey.of(RegistryKeys.STRUCTURE, new Identifier("minecraft", "eye_of_ender_located"));

        BlockPos coords = p.getServer().getWorld(p.getWorld().getRegistryKey()).locateStructure(strongholdTag, currentPos, 3000, true);
        return (coords != null ? coords : BlockPos.ORIGIN);
    }

    public static BlockPos findVillage(PlayerEntity p, BlockPos currentPos) {

        TagKey<Structure> villageTag = TagKey.of(RegistryKeys.STRUCTURE, new Identifier("minecraft", "village"));

        BlockPos coords = p.getServer().getWorld(p.getWorld().getRegistryKey()).locateStructure(villageTag, currentPos, 3000, true);
        return (coords != null ? coords : BlockPos.ORIGIN);
    }

}
