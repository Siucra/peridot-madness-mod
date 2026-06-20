package net.apple.peridotmadnessmod.item;

import net.apple.peridotmadnessmod.PeridotMadnessMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {
    public static final TagKey<Item> PERIDOT_TOOL_MATERIALS = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(PeridotMadnessMod.MOD_ID, "peridot_tool_materials")
    );

    public static final ToolMaterial PERIDOT = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            32,
            9.0F,
            4.0F,
            15,
            PERIDOT_TOOL_MATERIALS
    );
}
