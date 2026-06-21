package net.apple.peridotmadnessmod.item;

import net.apple.peridotmadnessmod.PeridotMadnessMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.equipment.ArmorType;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PeridotMadnessMod.MOD_ID);

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ITEMS.register(name, () -> new BlockItem(
                block.get(),
                new Item.Properties()
                        .setId(ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(PeridotMadnessMod.MOD_ID, name)
                        ))
        ));
    }

    public static final RegistryObject<Item> PERIDOT = ITEMS.register("peridot",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(
                            Registries.ITEM,
                            Identifier.fromNamespaceAndPath(PeridotMadnessMod.MOD_ID, "peridot")
                    )))
    );

    public static final RegistryObject<Item> PERIDOT_AXE = ITEMS.register("peridot_axe",
            () -> new AxeItem(
                    ModToolMaterials.PERIDOT,
                    5.0F,
                    -2.6F,
                    itemProperties("peridot_axe")
            )
    );

    public static final RegistryObject<Item> PERIDOT_PICKAXE = ITEMS.register("peridot_pickaxe",
            () -> new Item(itemProperties("peridot_pickaxe")
                    .pickaxe(ModToolMaterials.PERIDOT, 1.0F, -2.0F))
    );

    public static final RegistryObject<Item> PERIDOT_SHOVEL = ITEMS.register("peridot_shovel",
            () -> new ShovelItem(
                    ModToolMaterials.PERIDOT,
                    1.5F,
                    -2.4F,
                    itemProperties("peridot_shovel")
            )
    );

    public static final RegistryObject<Item> PERIDOT_HOE = ITEMS.register("peridot_hoe",
            () -> new HoeItem(
                    ModToolMaterials.PERIDOT,
                    -4.0F,
                    -1.0F,
                    itemProperties("peridot_hoe")
            )
    );

    public static final RegistryObject<Item> PERIDOT_SWORD = ITEMS.register("peridot_sword",
            () -> new Item(itemProperties("peridot_sword")
                    .sword(ModToolMaterials.PERIDOT, 3.0F, -2.0F))
    );

    private static Item.Properties itemProperties(String name) {
        return new Item.Properties()
                .setId(ResourceKey.create(
                        Registries.ITEM,
                        Identifier.fromNamespaceAndPath(PeridotMadnessMod.MOD_ID, name)
                ));
    }

    public static final RegistryObject<Item> PERIDOT_HELMET = ITEMS.register("peridot_helmet",
            () -> new Item(itemProperties("peridot_helmet")
                    .humanoidArmor(ModArmorMaterials.PERIDOT, ArmorType.HELMET))
    );

    public static final RegistryObject<Item> PERIDOT_LEGGINGS = ITEMS.register("peridot_leggings",
            () -> new Item(itemProperties("peridot_leggings")
                    .humanoidArmor(ModArmorMaterials.PERIDOT, ArmorType.LEGGINGS))
    );

    public static final RegistryObject<Item> PERIDOT_CHESTPLATE = ITEMS.register("peridot_chestplate",
            () -> new Item(itemProperties("peridot_chestplate")
                    .humanoidArmor(ModArmorMaterials.PERIDOT, ArmorType.CHESTPLATE))
    );

    public static final RegistryObject<Item> PERIDOT_BOOTS = ITEMS.register("peridot_boots",
            () -> new Item(itemProperties("peridot_boots")
                    .humanoidArmor(ModArmorMaterials.PERIDOT, ArmorType.BOOTS))
    );

    public static void register(BusGroup eventBus) {
        ITEMS.register(eventBus);
    }
}
