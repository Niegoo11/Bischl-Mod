package us.diewaldmert.bischlmod.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import us.diewaldmert.bischlmod.entity.custom.BischlEntity;
import us.diewaldmert.bischlmod.util.ModStructureFinder;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand,
                                 Entity entity, @Nullable EntityHitResult hitResult) {
        if (!(entity instanceof BischlEntity && !world.isClient)) return null;
        ItemStack diamonds = new ItemStack(Items.DIAMOND);
        if (!(player.getInventory().contains(diamonds) && diamonds.getCount() == 6)) return null;

        int x = ModStructureFinder.findNearestStronghold(player, player.getBlockPos()).getX();
        int y = ModStructureFinder.findNearestStronghold(player, player.getBlockPos()).getY();
        int z = ModStructureFinder.findNearestStronghold(player, player.getBlockPos()).getZ();

        player.getInventory().main.add(new ItemStack(Items.PAPER).setCustomName(Text.of("§aX: §6" + x + " §7| §aY: §6" + y + " §7| §aZ: §6" + z)));

        return ActionResult.PASS;
    }
}
