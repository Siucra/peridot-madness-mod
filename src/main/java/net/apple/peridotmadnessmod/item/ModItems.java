package net.apple.peridotmadnessmod.item;

import net.apple.peridotmadnessmod.PeridotMadnessMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
                    -3.0F,
                    new Item.Properties()
                            .setId(ResourceKey.create(
                                    Registries.ITEM,
                                    Identifier.fromNamespaceAndPath(PeridotMadnessMod.MOD_ID, "peridot_axe")
                            ))
            )
    );

    public static void register(BusGroup eventBus) {
        ITEMS.register(eventBus);
    }
}
