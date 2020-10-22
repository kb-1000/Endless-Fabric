package com.remodstudios.endless_fabric.item;

import com.remodstudios.endless_fabric.Endless;
import com.remodstudios.endless_fabric.block.EndlessModBlocks;
import com.remodstudios.endless_fabric.fluid.EndlessModFluids;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class EndlessModItems {
    public static final Item TOPAZ_GEM = register(new Item(new Item.Settings().group(ItemGroup.MISC)), "topaz_gem");
    public static final Item FINALLIUM_SHARD = register(new Item(new Item.Settings().group(ItemGroup.MISC)), "finallium_shard");
    public static final Item TOPAZ_ORE = register(EndlessModBlocks.TOPAZ_ORE, "topaz_ore", new Item.Settings().group(ItemGroup.MISC));
    public static final Item FINALLIUM_ORE = register(EndlessModBlocks.FINALLIUM_ORE, "finallium_ore", new Item.Settings().group(ItemGroup.MISC));
    public static final Item PHAZED_VOID = register(EndlessModBlocks.PHAZED_VOID, "phazed_void", new Item.Settings().group(ItemGroup.MISC));
    public static final Item RUSTED_IRON_BLOCK = register(EndlessModBlocks.RUSTED_IRON_BLOCK, "phazed_void", new Item.Settings().group(ItemGroup.MISC));
    public static final Item TOPAZ_BLOCK = register(EndlessModBlocks.TOPAZ_BLOCK, "topaz_block", new Item.Settings().group(ItemGroup.MISC));
    public static final Item MOLTEN_TOPAZ_BUCKET = register(new BucketItem(EndlessModFluids.MOLTEN_TOPAZ, new Item.Settings().group(ItemGroup.MISC)), "molten_topaz_bucket");

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
