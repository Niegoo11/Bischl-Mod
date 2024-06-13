package us.diewaldmert.bischlmod.commands;

import com.mojang.brigadier.Command;
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
import us.diewaldmert.bischlmod.util.ModStructureFinder;

import static net.minecraft.server.command.CommandManager.literal;

public class ModCommands {

    public static void registerCommands() {
        BischlMod.LOGGER.info("Registering Commands for " + BischlMod.MOD_ID);

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("foo")
                .executes(context -> {
                    ServerPlayerEntity p = context.getSource().getPlayer();

                    ServerCommandSource source = context.getSource();
                    ServerPlayerEntity player = source.getPlayer();
                    BlockPos currentPos = player.getBlockPos();

                    TagKey<Structure> strongholdTag = TagKey.of(RegistryKeys.STRUCTURE, new Identifier("minecraft", "eye_of_ender_located"));

                    BlockPos cords = source.getWorld().locateStructure(strongholdTag, currentPos, 10000, true);

                    context.getSource().sendFeedback(() -> Text.of(strongholdTag + " and " + currentPos), false);
                    context.getSource().sendFeedback(() -> Text.of("§aSome Nearest Structure §7(§6" + strongholdTag + "§7): §r" + (cords != null ? "§aX: §6" + cords.getX() + " §aY: §6" + cords.getY() + " §aZ: §6" + cords.getZ() : "§4§n<not found>")), false);

                    context.getSource().sendFeedback(() -> Text.of("\n"), false);
                    context.getSource().sendFeedback(() -> Text.of("§a§lPer Method: §6§l" + ModStructureFinder.findNearestStronghold(player, currentPos)), false);
                    return 1;
                })));
    }

}