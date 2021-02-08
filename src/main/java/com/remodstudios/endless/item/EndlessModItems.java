package com.remodstudios.endless.item;

import com.remodstudios.endless.Endless;
import com.remodstudios.endless.block.EndlessModBlocks;
import com.remodstudios.endless.fluid.EndlessModFluids;
import com.remodstudios.yarnandneedles.datagen.ResourceGenerator;
import com.remodstudios.yarnandneedles.datagen.generators.item.BlockItemGenerator;
import com.remodstudios.yarnandneedles.datagen.generators.item.SimpleItemGenerator;
import com.remodstudios.yarnandneedles.items.ItemRegistry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class EndlessModItems extends ItemRegistry {
	public static final EndlessModItems INSTANCE = new EndlessModItems();

	private final ItemGroup GROUP
			= FabricItemGroupBuilder.build(
				Endless.id("group"),
				() -> new ItemStack(EndlessModItems.INSTANCE.TOPAZ_GEM)
	);

	//region Item declarations
	private final FabricItemSettings BASE_SETTINGS = new FabricItemSettings().group(GROUP);

    public final Item TOPAZ_GEM 			= add("topaz_gem");
    public final Item FINALLIUM_SHARD 		= add("finallium_shard");

	//TODO: move to YNN? - leocth
	private final ResourceGenerator HANDHELD = new SimpleItemGenerator(new Identifier("item/handheld"));
	public final Item FINALLIUM_SWORD
			= add("finallium_sword",
					HANDHELD,
					new SwordItem(EndlessToolMaterials.FINALLIUM, 3, -2.4F, BASE_SETTINGS)
			);
	public final Item FINALLIUM_SHOVEL 		=
			add("finallium_shovel", HANDHELD,
					new ShovelItem(EndlessToolMaterials.FINALLIUM, 1.5f, -3f, BASE_SETTINGS)
			);
	public final Item FINALLIUM_PICKAXE 	=
			add("finallium_pickaxe", HANDHELD,
					new ModPickaxeItem(EndlessToolMaterials.FINALLIUM, 1, -2.8f, BASE_SETTINGS)
			);
	public final Item FINALLIUM_AXE 		=
			add("finallium_axe", HANDHELD,
					new ModAxeItem(EndlessToolMaterials.FINALLIUM, 6.0F, -3.1F, BASE_SETTINGS)
			);
	public final Item FINALLIUM_HOE 		=
			add("finallium_hoe", HANDHELD,
					new ModHoeItem(EndlessToolMaterials.FINALLIUM, -2, -1.0F, BASE_SETTINGS)
			);
	public final Item FINALLIUM_HELMET 		=
			add("finallium_helmet",
					new ArmorItem(EndlessArmorMaterials.FINALLIUM, EquipmentSlot.HEAD, BASE_SETTINGS)
			);
	public final Item FINALLIUM_CHESTPLATE 	=
			add("finallium_chestplate",
					new ArmorItem(EndlessArmorMaterials.FINALLIUM, EquipmentSlot.CHEST, BASE_SETTINGS)
			);
	public final Item FINALLIUM_LEGGINGS 	=
			add("finallium_leggings",
					new ArmorItem(EndlessArmorMaterials.FINALLIUM, EquipmentSlot.LEGS, BASE_SETTINGS)
			);
	public  final Item FINALLIUM_BOOTS 		=
			add("finallium_boots",
					new ArmorItem(EndlessArmorMaterials.FINALLIUM, EquipmentSlot.FEET, BASE_SETTINGS)
			);

    public final Item COBALT_DUST 			= add("cobalt_dust");
	public final Item COBALT_INGOT 			= add("cobalt_ingot");
	// hidden from item group :yeef:
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
	public final BlockItem ASHEN_ENDSTONE = addBlockItem("ashen_endstone", EndlessModBlocks.INSTANCE.ASHEN_ENDSTONE);
	public final BlockItem COBALT_ORE = addBlockItem("cobalt_ore", EndlessModBlocks.INSTANCE.COBALT_ORE);
	public final BlockItem COBALT_BLOCK = addBlockItem("cobalt_block", EndlessModBlocks.INSTANCE.COBALT_BLOCK);
	public final BlockItem BEACON_OF_UNDYING = addBlockItem("beacon_of_undying", EndlessModBlocks.INSTANCE.BEACON_OF_UNDYING);

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
