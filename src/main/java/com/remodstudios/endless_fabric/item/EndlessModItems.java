package com.remodstudios.endless_fabric.item;

import com.remodstudios.endless_fabric.Endless;
import com.remodstudios.endless_fabric.block.EndlessModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class EndlessModItems {
    public static final Item TOPAZ_GEM = register(new Item(new Item.Settings().group(ItemGroup.MISC)), "topaz_gen");
    public static final Item TOPAZ_ORE = register(EndlessModBlocks.TOPAZ_ORE, "topaz_ore", new Item.Settings().group(ItemGroup.MISC));
    public static final Item FINALLIUM_ORE = register(EndlessModBlocks.FINALLIUM_ORE, "finallium_ore", new Item.Settings().group(ItemGroup.MISC));

    private static Item register(Item item, String name) {
        return Registry.register(Registry.ITEM, new Identifier(Endless.MOD_ID, name), item);
    }

    private static Item register(Block block, String name, Item.Settings settings) {
        return register(new BlockItem(block, settings), name);
    }

    public static void init() {
        // just loads the class
    }
}
