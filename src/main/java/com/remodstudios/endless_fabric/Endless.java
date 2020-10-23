package com.remodstudios.endless_fabric;

import com.remodstudios.endless_fabric.block.EndlessModBlocks;
import com.remodstudios.endless_fabric.block.entity.EndlessModBlockEntityTypes;
import com.remodstudios.endless_fabric.block.entity.screen.EndlessModScreenHandlerTypes;
import com.remodstudios.endless_fabric.fluid.EndlessModFluids;
import com.remodstudios.endless_fabric.item.EndlessModItems;
import com.remodstudios.endless_fabric.world.feature.EndlessModFeatures;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class Endless implements ModInitializer {
    public static final String MOD_ID = "endless_fabric";
    public static final String MOD_NAME = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(IllegalStateException::new).getMetadata().getName();
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Endless");
        EndlessModItems.init();
        EndlessModBlocks.init();
		EndlessModScreenHandlerTypes.init();
		EndlessModBlockEntityTypes.init();
        EndlessModFeatures.init();
		EndlessModFluids.init();
    }
}
