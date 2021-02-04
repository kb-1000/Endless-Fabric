package com.remodstudios.endless;

import com.remodstudios.endless.block.EndlessModBlocks;
import com.remodstudios.endless.block.entity.EndlessModBlockEntityTypes;
import com.remodstudios.endless.fluid.EndlessModFluids;
import com.remodstudios.endless.item.EndlessModItems;
import com.remodstudios.endless.world.feature.EndlessModFeatures;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class Endless implements ModInitializer {
    public static final String MOD_ID = "endless";
    public static final String MOD_NAME = "Endless";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Endless");
        EndlessModItems.init();
        EndlessModBlocks.init();
		EndlessModBlockEntityTypes.init();
        EndlessModFeatures.init();
		EndlessModFluids.init();
    }

    public static Identifier id(String path) { return new Identifier(MOD_ID, path); }
}
