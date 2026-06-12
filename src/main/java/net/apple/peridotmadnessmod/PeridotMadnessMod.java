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
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "peridotmadnessmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public PeridotMadnessMod(FMLJavaModLoadingContext context) {
        var modBusGroup = context.getModBusGroup();

        FMLCommonSetupEvent.getBus(modBusGroup).addListener(this::commonSetup);

        BuildCreativeModeTabContentsEvent.BUS.addListener(PeridotMadnessMod::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModBlocks.register(modBusGroup);
        ModItems.register(modBusGroup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        PeridotMadnessMod.LOGGER.info("Creative tab event fired for: {}", event.getTabKey());

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.PERIDOT_ORE.get().asItem());
            PeridotMadnessMod.LOGGER.info("Added peridot ore to natural blocks tab");
        }
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
