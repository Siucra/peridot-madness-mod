package net.apple.peridotmadnessmod.item;

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

        if (event.getEntity() instanceof Zombie zombie) {
            maybeEquipPeridotArmor(zombie);
        } else if (event.getEntity() instanceof Skeleton skeleton) {
            maybeEquipPeridotArmor(skeleton);
        }
    }

    private static void maybeEquipPeridotArmor(Mob mob) {
        if (mob.getRandom().nextFloat() > 0.10F) {
            return;
        }

        mob.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ModItems.PERIDOT_HELMET.get()));
        mob.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ModItems.PERIDOT_CHESTPLATE.get()));
        mob.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ModItems.PERIDOT_LEGGINGS.get()));
        mob.setItemSlot(EquipmentSlot.FEET, new ItemStack(ModItems.PERIDOT_BOOTS.get()));

        mob.setDropChance(EquipmentSlot.HEAD, 0.05F);
        mob.setDropChance(EquipmentSlot.CHEST, 0.05F);
        mob.setDropChance(EquipmentSlot.LEGS, 0.05F);
        mob.setDropChance(EquipmentSlot.FEET, 0.05F);

        mob.setCanPickUpLoot(true);
    }
}
