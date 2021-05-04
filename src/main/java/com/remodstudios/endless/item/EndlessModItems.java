package com.remodstudios.endless.item;

import com.remodstudios.endless.Endless;
import com.remodstudios.yarnandneedles.items.ItemRegistry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.Tag;

@SuppressWarnings("unused")
public class EndlessModItems extends ItemRegistry {
	public static final EndlessModItems INSTANCE = new EndlessModItems();

	private final ItemGroup GROUP
			= FabricItemGroupBuilder.build(
				Endless.id("group"),
				() -> new ItemStack(Blocks.END_PORTAL_FRAME)
	);

	//region Item declarations
	private final FabricItemSettings BASE_SETTINGS = new FabricItemSettings().group(GROUP).maxCount(64);
	private final FabricItemSettings TOOL_SETTINGS = new FabricItemSettings().group(GROUP).maxCount(1);

	//endregion

	public EndlessModItems() {
		super(Endless.MOD_ID);
	}

	@Override
	protected FabricItemSettings getDefaultSettings() {
		return BASE_SETTINGS;
	}

	@Override
	public void init() {
		super.init();
		Tags.init();
	}

	public static class Tags {
    	public static final Tag<Item> BEACON_OF_UNDYING_PAYMENT_ITEMS = TagRegistry.item(Endless.id("beacon_of_undying_payment_items"));

    	public static void init() {
    		// just loads the class
		}
	}
}
