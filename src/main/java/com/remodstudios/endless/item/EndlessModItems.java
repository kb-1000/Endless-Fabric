package com.remodstudios.endless.item;

import com.remodstudios.endless.Endless;
import com.remodstudios.endless.block.EndlessModBlocks;
import com.remodstudios.endless.fluid.EndlessModFluids;
import com.remodstudios.yarnandneedles.datagen.ResourceGenerators;
import com.remodstudios.yarnandneedles.datagen.generators.item.BlockItemGenerator;
import com.remodstudios.yarnandneedles.items.ItemRegistry;
import com.remodstudios.yarnandneedles.items.ModAxeItem;
import com.remodstudios.yarnandneedles.items.ModHoeItem;
import com.remodstudios.yarnandneedles.items.ModPickaxeItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
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
