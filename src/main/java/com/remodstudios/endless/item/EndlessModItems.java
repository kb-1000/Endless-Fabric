package com.remodstudios.endless.item;

import com.remodstudios.endless.Endless;
import com.remodstudios.endless.block.EndlessModBlocks;
import com.remodstudios.endless.fluid.EndlessModFluids;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.tag.TagRegistry;

@SuppressWarnings("unused")
public class EndlessModItems {
	// Items
	private static final FabricItemSettings DEFAULT_SETTINGS = new FabricItemSettings().group(ItemGroup.MISC);

    public static final Item TOPAZ_GEM 			= new Item(DEFAULT_SETTINGS);
    public static final Item FINALLIUM_SHARD 	= new Item(DEFAULT_SETTINGS);
    public static final Item COBALT_DUST 		= new Item(DEFAULT_SETTINGS);
	public static final Item COBALT_INGOT 		= new Item(DEFAULT_SETTINGS);
	// hidden from item group :yeef:
	public static final Item MOLTEN_TOPAZ_BUCKET = new BucketItem(EndlessModFluids.MOLTEN_TOPAZ, new Item.Settings());

    // Block Item
    public static final Item TOPAZ_ORE = makeBlockItem(EndlessModBlocks.TOPAZ_ORE);
    public static final Item FINALLIUM_ORE = makeBlockItem(EndlessModBlocks.FINALLIUM_ORE);
    public static final Item PHAZED_VOID = makeBlockItem(EndlessModBlocks.PHAZED_VOID);
    public static final Item RUSTED_IRON_BLOCK = makeBlockItem(EndlessModBlocks.RUSTED_IRON_BLOCK);
    public static final Item TOPAZ_BLOCK = makeBlockItem(EndlessModBlocks.TOPAZ_BLOCK);
    public static final Item FLUID_CAULDRON = makeBlockItem(EndlessModBlocks.FLUID_CAULDRON);
	public static final Item ASHEN_ENDSTONE = makeBlockItem(EndlessModBlocks.ASHEN_ENDSTONE);
	public static final Item FINALLIUM_BLOCK = makeBlockItem(EndlessModBlocks.FINALLIUM_BLOCK);
	public static final Item COBALT_ORE = makeBlockItem(EndlessModBlocks.COBALT_ORE);
	public static final Item COBALT_BLOCK = makeBlockItem(EndlessModBlocks.COBALT_BLOCK);

    // Methods
    private static void register(Item item, String name) {
		Registry.register(Registry.ITEM, Endless.id(name), item);
	}

	private static BlockItem makeBlockItem(Block block) {
		return new BlockItem(block, DEFAULT_SETTINGS);
	}

    public static void init() {
		register(TOPAZ_GEM, "topaz_gem");
		register(FINALLIUM_SHARD, "finallium_shard");
		register(COBALT_DUST, "cobalt_dust");
		register(COBALT_INGOT, "cobalt_ingot");
		register(MOLTEN_TOPAZ_BUCKET, "molten_topaz_bucket");

		register(TOPAZ_ORE, "finallium_ore");
		register(PHAZED_VOID, "phazed_void");
		register(RUSTED_IRON_BLOCK, "rusted_iron_block");
		register(TOPAZ_BLOCK, "topaz_block");
		register(FLUID_CAULDRON, "fluid_cauldron");
		register(ASHEN_ENDSTONE, "ashen_endstone");
		register(FINALLIUM_BLOCK, "finallium_block");
		register(COBALT_ORE, "cobalt_ore");
		register(COBALT_BLOCK, "cobalt_block");
    	Tags.init();
    }

    public static class Tags {
    	public static final Tag<Item> BEACON_OF_UNDYING_PAYMENT_ITEMS = TagRegistry.item(Endless.id("beacon_of_undying_payment_items"));

    	public static void init() {
    		// just loads the class
		}
	}
}
