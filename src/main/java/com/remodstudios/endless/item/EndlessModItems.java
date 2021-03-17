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
				() -> new ItemStack(EndlessModItems.INSTANCE.TOPAZ_GEM)
	);

	//region Item declarations
	private final FabricItemSettings BASE_SETTINGS = new FabricItemSettings().group(GROUP).maxCount(64);
	private final FabricItemSettings TOOL_SETTINGS = new FabricItemSettings().group(GROUP).maxCount(1);

    public final Item TOPAZ_GEM 			= add("topaz_gem");
    public final Item FINALLIUM_SHARD 		= add("finallium_shard");

	public final Item FINALLIUM_SWORD
			= add("finallium_sword",
					ResourceGenerators.HANDHELD_ITEM,
					new SwordItem(EndlessToolMaterials.FINALLIUM, 3, -2.4F, TOOL_SETTINGS)
			);
	public final Item FINALLIUM_SHOVEL 		=
			add("finallium_shovel", ResourceGenerators.HANDHELD_ITEM,
					new ShovelItem(EndlessToolMaterials.FINALLIUM, 1.5f, -3f, TOOL_SETTINGS)
			);
	public final Item FINALLIUM_PICKAXE 	=
			add("finallium_pickaxe", ResourceGenerators.HANDHELD_ITEM,
					new ModPickaxeItem(EndlessToolMaterials.FINALLIUM, 1, -2.8f, TOOL_SETTINGS)
			);
	public final Item FINALLIUM_AXE 		=
			add("finallium_axe", ResourceGenerators.HANDHELD_ITEM,
					new ModAxeItem(EndlessToolMaterials.FINALLIUM, 6.0F, -3.1F, TOOL_SETTINGS)
			);
	public final Item FINALLIUM_HOE 		=
			add("finallium_hoe", ResourceGenerators.HANDHELD_ITEM,
					new ModHoeItem(EndlessToolMaterials.FINALLIUM, -2, -1.0F, TOOL_SETTINGS)
			);
	public final Item FINALLIUM_HELMET 		=
			add("finallium_helmet",
					new ArmorItem(EndlessArmorMaterials.FINALLIUM, EquipmentSlot.HEAD, TOOL_SETTINGS)
			);
	public final Item FINALLIUM_CHESTPLATE 	=
			add("finallium_chestplate",
					new ArmorItem(EndlessArmorMaterials.FINALLIUM, EquipmentSlot.CHEST, TOOL_SETTINGS)
			);
	public final Item FINALLIUM_LEGGINGS 	=
			add("finallium_leggings",
					new ArmorItem(EndlessArmorMaterials.FINALLIUM, EquipmentSlot.LEGS, TOOL_SETTINGS)
			);
	public  final Item FINALLIUM_BOOTS 		=
			add("finallium_boots",
					new ArmorItem(EndlessArmorMaterials.FINALLIUM, EquipmentSlot.FEET, TOOL_SETTINGS)
			);
	
	public final Item COBALT_DUST 			= add("cobalt_dust");
	public final Item COBALT_MAGNET			= add("cobalt_magnet", new CobaltMagnetItem(ToolMaterials.IRON, new Item.Settings().maxCount(1).maxDamage(128)));

	// "fewd" - LePichu
	public final Item PAPAYA 				= add("papaya", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(5).snack().build())));

	// "misc stuff because yes" - LePichu
	public final Item MUSIC_TEST 			= add("test", new RecordItem(11, SoundEvents.MUSIC_DISC_11, new Item.Settings().group(GROUP).maxCount(1)));

	// hidden from item group :yeef: - leocth
	public final Item MOLTEN_TOPAZ_BUCKET =
			add("molten_topaz_bucket",
				new BucketItem(EndlessModFluids.MOLTEN_TOPAZ, new Item.Settings())
			);

    public final BlockItem TOPAZ_ORE = addBlockItem("topaz_ore", EndlessModBlocks.INSTANCE.TOPAZ_ORE);
	public final BlockItem TOPAZ_BLOCK = addBlockItem("topaz_block", EndlessModBlocks.INSTANCE.TOPAZ_BLOCK);
    public final BlockItem FINALLIUM_ORE = addBlockItem("finallium_ore", EndlessModBlocks.INSTANCE.FINALLIUM_ORE);
	public final BlockItem FINALLIUM_BLOCK = addBlockItem("finallium_block", EndlessModBlocks.INSTANCE.FINALLIUM_BLOCK);
    public final BlockItem PHAZED_VOID = addBlockItem("phazed_void", EndlessModBlocks.INSTANCE.PHAZED_VOID);
    public final BlockItem RUSTED_IRON_BLOCK = addBlockItem("rusted_iron_block", EndlessModBlocks.INSTANCE.RUSTED_IRON_BLOCK);
    public final BlockItem FLUID_CAULDRON =
			addBlockItem("fluid_cauldron",
					new BlockItemGenerator(Endless.id("cauldron/cauldron_base")),
					EndlessModBlocks.INSTANCE.FLUID_CAULDRON
			);
	public final BlockItem COBALT_ORE = addBlockItem("cobalt_ore", EndlessModBlocks.INSTANCE.COBALT_ORE);
	public final BlockItem COBALT_BLOCK = addBlockItem("cobalt_block", EndlessModBlocks.INSTANCE.COBALT_BLOCK);
	public final BlockItem BEACON_OF_UNDYING = addBlockItem("beacon_of_undying", EndlessModBlocks.INSTANCE.BEACON_OF_UNDYING);
	public final BlockItem ASHEN_ENDSTONE = addBlockItem("ashen_endstone", EndlessModBlocks.INSTANCE.ASHEN_ENDSTONE);
	public final BlockItem CRYSTILLIUM = addBlockItem("crystillium", EndlessModBlocks.INSTANCE.CRYSTILLIUM);
	public final BlockItem PURPUR_GRASS = addBlockItem("purpur_grass", EndlessModBlocks.INSTANCE.PURPUR_GRASS);
	public final BlockItem TEALITE = addBlockItem("tealite", EndlessModBlocks.INSTANCE.TEALITE);
	public final BlockItem RHYOLITE = addBlockItem("rhyolite", EndlessModBlocks.INSTANCE.RHYOLITE);
	public final BlockItem POLISHED_RHYOLITE = addBlockItem("polished_rhyolite", EndlessModBlocks.INSTANCE.POLISHED_RHYOLITE);

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
