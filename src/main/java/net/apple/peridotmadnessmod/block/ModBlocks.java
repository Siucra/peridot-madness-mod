package net.apple.peridotmadnessmod.block;

import net.apple.peridotmadnessmod.PeridotMadnessMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.apple.peridotmadnessmod.item.ModItems.ITEMS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PeridotMadnessMod.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static final RegistryObject<Block> PERIDOT_ORE = registerBlock("peridot_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(
                                    Registries.BLOCK,
                                    Identifier.fromNamespaceAndPath(PeridotMadnessMod.MOD_ID, "peridot_ore")
                            ))
                            .strength(3f)
                            .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Item> PERIDOT_ORE_ITEM =
            ITEMS.register("peridot_ore", () -> new BlockItem(
                    PERIDOT_ORE.get(),
                    new Item.Properties()
                            .setId(ResourceKey.create(
                                    Registries.ITEM,
                                    Identifier.fromNamespaceAndPath(PeridotMadnessMod.MOD_ID, "peridot_ore")
                            ))
            ));
    public static void register(BusGroup eventBus) {
        BLOCKS.register(eventBus);
    }

}
