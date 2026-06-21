package net.apple.peridotmadnessmod;

import com.mojang.logging.LogUtils;
import net.apple.peridotmadnessmod.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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

        ModBlocks.register(modBusGroup);
        ModItems.register(modBusGroup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {//PLACEHOLDER
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        //PeridotMadnessMod.LOGGER.info("Creative tab event fired for: {}", event.getTabKey());

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) { //checks if the tabs is the Natural Blocks tab
            event.accept(ModBlocks.PERIDOT_ORE.get().asItem()); //if yes, add the block
           // PeridotMadnessMod.LOGGER.info("Added peridot ore to natural blocks tab");
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.BLOCK_OF_PERIDOT.get().asItem());
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.PERIDOT.get());
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.PERIDOT_AXE.get());
            event.accept(ModItems.PERIDOT_PICKAXE.get());
            event.accept(ModItems.PERIDOT_SHOVEL.get());
            event.accept(ModItems.PERIDOT_SWORD.get());
            event.accept(ModItems.PERIDOT_HOE.get());
            event.accept(ModItems.PERIDOT_HELMET.get());
            event.accept(ModItems.PERIDOT_BOOTS.get());
            event.accept(ModItems.PERIDOT_CHESTPLATE.get());
            event.accept(ModItems.PERIDOT_LEGGINGS.get());
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.PERIDOT_AXE.get());
            event.accept(ModItems.PERIDOT_PICKAXE.get());
            event.accept(ModItems.PERIDOT_SHOVEL.get());
            event.accept(ModItems.PERIDOT_SWORD.get());
            event.accept(ModItems.PERIDOT_HOE.get());
            event.accept(ModItems.PERIDOT_HELMET.get());
            event.accept(ModItems.PERIDOT_BOOTS.get());
            event.accept(ModItems.PERIDOT_CHESTPLATE.get());
            event.accept(ModItems.PERIDOT_LEGGINGS.get());
        }

    }
    @Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
