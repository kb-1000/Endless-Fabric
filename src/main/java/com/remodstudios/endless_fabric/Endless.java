package com.remodstudios.endless_fabric;

import com.remodstudios.endless_fabric.common.register.EndlessModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Endless implements ModInitializer {
    public static final String MOD_ID = "endless_fabric";
    public static final String MOD_NAME = "Endless";

    public static Logger LOGGER = LogManager.getLogger(MOD_NAME);

    //item instances
    public static final Item TOPAZ_GEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        // haha yes pichu smol and not best
        log(Level.INFO, "Registering Endless' Items...");
        EndlessModItems.registerItems();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, message);
    }

}
