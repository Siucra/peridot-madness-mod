package net.apple.peridotmadnessmod.item;


import com.google.common.collect.Maps;
import net.apple.peridotmadnessmod.PeridotMadnessMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class ModArmorMaterials {
    public static final TagKey<Item> PERIDOT_ARMOR_MATERIALS = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(PeridotMadnessMod.MOD_ID, "peridot_armor_materials")
    );

    public static final ResourceKey<EquipmentAsset> PERIDOT_ARMOR_ASSET = ResourceKey.create(
            EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(PeridotMadnessMod.MOD_ID,"peridot")
    );

    public static final ArmorMaterial PERIDOT = new ArmorMaterial(
            7, // gold durability multiplier
            Maps.newEnumMap(Map.of(
                    ArmorType.BOOTS, 3,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.HELMET, 3,
                    ArmorType.BODY, 19
            )), // netherite defense values
            15, // netherite enchantability, or use 25 for gold-like enchanting
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0F, // netherite toughness
            0.1F, // netherite knockback resistance
            PERIDOT_ARMOR_MATERIALS,
            PERIDOT_ARMOR_ASSET
    );
}

