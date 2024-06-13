package us.diewaldmert.bischlmod.util;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.server.command.ServerCommandSource;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.Structure;
import us.diewaldmert.bischlmod.BischlMod;

import static net.minecraft.server.command.CommandManager.*;

public class ModStructureFinder {

    public static BlockPos findNearestStronghold(PlayerEntity p, BlockPos currentPos) {

        TagKey<Structure> strongholdTag = TagKey.of(RegistryKeys.STRUCTURE, new Identifier("minecraft", "eye_of_ender_located"));


        return p.getServer().getWorld(p.getWorld().getRegistryKey()).locateStructure(strongholdTag, currentPos, 10000, true);
    }

    public static BlockPos findNearestPyramid(PlayerEntity p, BlockPos currentPos) {

        TagKey<Structure> PyramidTag = TagKey.of(RegistryKeys.STRUCTURE, new Identifier("minecraft", "on_jungle_explorer_maps"));


        return null;
    }

}
