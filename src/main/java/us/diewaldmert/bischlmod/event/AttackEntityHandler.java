package us.diewaldmert.bischlmod.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import us.diewaldmert.bischlmod.BischlMod;
import us.diewaldmert.bischlmod.entity.custom.BischlEntity;
import us.diewaldmert.bischlmod.util.ModStructureFinder;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand,
                                 Entity entity, @Nullable EntityHitResult hitResult) {
        if (!(entity instanceof BischlEntity) || world.isClient) return ActionResult.PASS;

        // Prüfen, ob der Spieler 6 Diamanten im Inventar hat
        //if (!hasExactItemCountInMainHand(player, Items.DIAMOND, 6)) return ActionResult.PASS;
        if (hasExactItemCountInMainHand(player, Items.DIAMOND, 6)) {
            removeExactItemCount(player, Items.DIAMOND, 6);

            // Koordinaten der nächsten Festung finden
            BlockPos strongholdPos = ModStructureFinder.findStronghold(player, player.getBlockPos());
            int x = strongholdPos.getX();
            //int y = strongholdPos.getY();
            int z = strongholdPos.getZ();

            // Papier mit Koordinaten erstellen
            ItemStack paper = new ItemStack(Items.PAPER);
            paper.setCustomName(Text.of("§3Stronghold: §aX: §6" + x + " §7| §aY: §6~ §7| §aZ: §6" + z));

            // Papier in der Welt droppen
            dropItem(world, player.getPos(), paper);
        } else if (hasExactItemCountInMainHand(player, Items.EMERALD, 10)) {
            removeExactItemCount(player, Items.EMERALD, 10);

            BlockPos villagePos = ModStructureFinder.findVillage(player, player.getBlockPos());
            int x = villagePos.getX();
            int z = villagePos.getZ();

            ItemStack paper = new ItemStack(Items.PAPER);
            paper.setCustomName(Text.of("§eVillage: §aX: §6" + x + " §7| §aY: §6~ §7| §aZ: §6" + z));

            dropItem(world, player.getPos(), paper);
        } else
            return ActionResult.PASS;



        return ActionResult.SUCCESS;
    }

    private void removeExactItemCount(PlayerEntity player, Item item, int count) {
        int remaining = count;
        for (int i = 0; i < player.getInventory().main.size(); i++) {
            ItemStack stack = player.getInventory().main.get(i);
            if (stack.getItem() == item) {
                int stackCount = stack.getCount();
                if (stackCount > remaining) {
                    stack.decrement(remaining);
                    return;
                } else {
                    player.getInventory().main.set(i, ItemStack.EMPTY);
                    remaining -= stackCount;
                    if (remaining == 0) {
                        return;
                    }
                }
            }
        }
    }


    private boolean hasExactItemCount(PlayerEntity player, Item item, int count) {
        int totalCount = 0;
        for (ItemStack stack : player.getInventory().main) {
            if (stack.getItem() == item) {
                totalCount += stack.getCount();
            }
            if (totalCount >= count) {
                return true;
            }
        }
        return false;
    }

    private boolean hasExactItemCountInMainHand(PlayerEntity player, Item item, int count) {
        ItemStack mainHandStack = player.getMainHandStack();
        return mainHandStack.getItem() == item && mainHandStack.getCount() >= count;
    }

    private void dropItem(World world, Vec3d pos, ItemStack itemStack) {
        ItemEntity itemEntity = new ItemEntity(world, pos.x, pos.y, pos.z, itemStack);
        world.spawnEntity(itemEntity);
    }
}
