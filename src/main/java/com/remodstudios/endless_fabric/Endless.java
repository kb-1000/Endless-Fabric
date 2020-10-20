package com.remodstudios.endless_fabric;

import com.remodstudios.endless_fabric.common.register.EndlessModItems;
import com.remodstudios.endless_fabric.common.register.EndlessModBlocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The common initializer of Endless.
 *
 * @author LePichu
 * @author YTG1234
 */
public class Endless implements ModInitializer {
    public static final String MOD_ID = "endless_fabric";
    public static final String MOD_NAME = "Endless";

    public static Logger LOGGER = LogManager.getLogger(MOD_NAME);

    /**
     * Initializes mod and registers items.
     */
    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        // haha yes pichu smol and not best
        log(Level.INFO, "Registering Endless' Items...");
        EndlessModItems.registerItems();
        EndlessModBlocks.registerBlocks();
    }

    /**
     * Logs a message to the console with this mod's logger.
     * @param level The {@linkplain Level log level} to log the message in.
     * @param message The message to log.
     */
    public static void log(Level level, String message){
        LOGGER.log(level, message);
    }

}
