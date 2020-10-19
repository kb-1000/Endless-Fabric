package com.remodstudios.endless_fabric.common.register;

import com.remodstudios.endless_fabric.Endless;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * A class containing all of the mod's items.
 *
 * @author YTG1234
 */
public final class EndlessModItems {
    public static final Item TOPAZ_GEM;

    static {
        TOPAZ_GEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    }

    private EndlessModItems() {
    }

    /**
     * Registers all of the mod's items.
     */
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Endless.MOD_ID, "topaz_gem"), TOPAZ_GEM);
    }
}
