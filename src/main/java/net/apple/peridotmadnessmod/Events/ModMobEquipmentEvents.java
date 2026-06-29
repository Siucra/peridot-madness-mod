package net.apple.peridotmadnessmod.Events;

import net.apple.peridotmadnessmod.item.ModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

public class ModMobEquipmentEvents {

    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide()) {
            return;
        }
        if(event.getEntity() instanceof Zombie zombie){
            maybeHoldPeridotItem(zombie);
        }
        else if(event.getEntity() instanceof Skeleton skeleton){
            maybeHoldPeridotItem(skeleton);
        }

    }

    private static void maybeHoldPeridotItem(Mob mob){
        if (mob.getRandom().nextFloat() >0.10f){
            return;
        }

        ItemStack[] possibleItems = {
                new ItemStack(ModItems.PERIDOT_SWORD.get()),
                new ItemStack(ModItems.PERIDOT_SHOVEL.get()),
                new ItemStack(ModItems.PERIDOT_AXE.get()),
                new ItemStack(ModItems.PERIDOT.get()),
                new ItemStack(ModItems.PERIDOT_HELMET.get()),
                new ItemStack(ModItems.PERIDOT_CHESTPLATE.get()),
                new ItemStack(ModItems.PERIDOT_LEGGINGS.get()),
                new ItemStack(ModItems.PERIDOT_BOOTS.get())
        };

        mob.setItemSlot(
                EquipmentSlot.MAINHAND,
                possibleItems[mob.getRandom().nextInt(possibleItems.length)]);
    }
}
