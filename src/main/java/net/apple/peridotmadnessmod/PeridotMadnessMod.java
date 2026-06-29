package net.apple.peridotmadnessmod;

import com.mojang.logging.LogUtils;
import net.apple.peridotmadnessmod.block.ModBlocks;
import net.apple.peridotmadnessmod.item.ModMobEquipmentEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import net.apple.peridotmadnessmod.item.ModItems;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(PeridotMadnessMod.MOD_ID)
public final class PeridotMadnessMod {
    public static final String MOD_ID = "peridotmadnessmod"; //unique ID
    public static final Logger LOGGER = LogUtils.getLogger(); //lets the mod print messages to game log/console


    public PeridotMadnessMod(FMLJavaModLoadingContext context) { //CONSTRUCTOR
        var modBusGroup = context.getModBusGroup(); //N.B! where events are announced and listeners are called

        FMLCommonSetupEvent.getBus(modBusGroup).addListener(this::commonSetup); //calls my commonSetup method

        //When creative mod tabs are being built, call addCreative
        BuildCreativeModeTabContentsEvent.BUS.addListener(PeridotMadnessMod::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC); //registers the mod's config file settings
        EntityJoinLevelEvent.BUS.addListener(ModMobEquipmentEvents::onEntityJoinLevel);

        ModBlocks.register(modBusGroup);
        ModItems.register(modBusGroup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {//PLACEHOLDER
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.getEntries().putAfter(
                    Items.DEEPSLATE_DIAMOND_ORE.getDefaultInstance(),
                    ModBlocks.PERIDOT_ORE.get().asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.getEntries().putAfter(
                    Items.DIAMOND_BLOCK.getDefaultInstance(),
                    ModBlocks.BLOCK_OF_PERIDOT.get().asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(
                    Items.DIAMOND.getDefaultInstance(),
                    ModItems.PERIDOT.get().asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            addPeridotToolsAfterDiamondTools(event, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(
                    ModItems.PERIDOT_HORSE_ARMOR.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.getEntries().putAfter(
                    Items.DIAMOND_SWORD.getDefaultInstance(),
                    ModItems.PERIDOT_SWORD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.accept(
                    ModItems.PERIDOT_HORSE_ARMOR.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            addPeridotArmorAfterDiamondArmor(event, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.SEARCH) {
            event.getEntries().putAfter(
                    Items.DIAMOND_BLOCK.getDefaultInstance(),
                    ModBlocks.BLOCK_OF_PERIDOT.get().asItem().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                    Items.DIAMOND_SWORD.getDefaultInstance(),
                    ModItems.PERIDOT_SWORD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.accept(
                    ModItems.PERIDOT_HORSE_ARMOR.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            addPeridotToolsAfterDiamondTools(event, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            addPeridotArmorAfterDiamondArmor(event, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private static void addPeridotToolsAfterDiamondTools(
            BuildCreativeModeTabContentsEvent event,
            CreativeModeTab.TabVisibility visibility
    ) {
        event.getEntries().putAfter(
                Items.DIAMOND_HOE.getDefaultInstance(),
                ModItems.PERIDOT_SHOVEL.get().getDefaultInstance(),
                visibility
        );

        event.getEntries().putAfter(
                ModItems.PERIDOT_SHOVEL.get().getDefaultInstance(),
                ModItems.PERIDOT_PICKAXE.get().getDefaultInstance(),
                visibility
        );

        event.getEntries().putAfter(
                ModItems.PERIDOT_PICKAXE.get().getDefaultInstance(),
                ModItems.PERIDOT_AXE.get().getDefaultInstance(),
                visibility
        );

        event.getEntries().putAfter(
                ModItems.PERIDOT_AXE.get().getDefaultInstance(),
                ModItems.PERIDOT_HOE.get().getDefaultInstance(),
                visibility
        );
    }

    private static void addPeridotArmorAfterDiamondArmor(
            BuildCreativeModeTabContentsEvent event,
            CreativeModeTab.TabVisibility visibility
    ) {
        event.getEntries().putAfter(
                Items.DIAMOND_BOOTS.getDefaultInstance(),
                ModItems.PERIDOT_HELMET.get().getDefaultInstance(),
                visibility
        );

        event.getEntries().putAfter(
                ModItems.PERIDOT_HELMET.get().getDefaultInstance(),
                ModItems.PERIDOT_CHESTPLATE.get().getDefaultInstance(),
                visibility
        );

        event.getEntries().putAfter(
                ModItems.PERIDOT_CHESTPLATE.get().getDefaultInstance(),
                ModItems.PERIDOT_LEGGINGS.get().getDefaultInstance(),
                visibility
        );

        event.getEntries().putAfter(
                ModItems.PERIDOT_LEGGINGS.get().getDefaultInstance(),
                ModItems.PERIDOT_BOOTS.get().getDefaultInstance(),
                visibility
        );
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}


