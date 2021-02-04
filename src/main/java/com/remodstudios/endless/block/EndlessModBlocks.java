package com.remodstudios.endless.block;

import com.remodstudios.endless.Endless;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

public class EndlessModBlocks {
    public static final Block TOPAZ_ORE;
	public static final Block TOPAZ_BLOCK;
    public static final Block FINALLIUM_ORE;
	public static final Block FINALLIUM_BLOCK;
	public static final Block COBALT_ORE;
	public static final Block COBALT_BLOCK;
    public static final Block RUSTED_IRON_BLOCK;
    public static final Block PHAZED_VOID;
    public static final Block MOLTEN_TOPAZ;
    public static final Block FLUID_CAULDRON;
    public static final Block BEACON_OF_UNDYING;
    public static final Block ASHEN_ENDSTONE;

    public static final Material PHAZED_VOID_MATERIAL = new FabricMaterialBuilder(MapColor.BLUE).notSolid().allowsMovement().build();

    private static void register(Block block, String name) {
        Registry.register(Registry.BLOCK, Endless.id(name), block);
    }

    public static void init() {
        register(TOPAZ_ORE, "topaz_ore");
		register(TOPAZ_BLOCK, "topaz_block");
		register(FINALLIUM_ORE, "finallium_ore");
		register(FINALLIUM_BLOCK, "finallium_block");
		register(COBALT_ORE, "cobalt_ore");
		register(COBALT_BLOCK, "cobalt_block");
		register(RUSTED_IRON_BLOCK, "rusted_iron_block");
		register(PHAZED_VOID, "phazed_void");
		register(MOLTEN_TOPAZ, "molten_topaz");
		register(FLUID_CAULDRON, "fluid_cauldron");
		register(BEACON_OF_UNDYING, "beacon_of_undying");
		register(ASHEN_ENDSTONE, "ashen_endstone");
    }

    static {
    	//TODO maybe reuse block settings? - leocth
		TOPAZ_ORE = new Block(
				FabricBlockSettings.copyOf(Blocks.END_STONE)
						.requiresTool()
						.breakByTool(FabricToolTags.PICKAXES, 2)
						.sounds(BlockSoundGroup.STONE));
		TOPAZ_BLOCK = new Block(
				FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)
						.requiresTool()
						.breakByTool(FabricToolTags.PICKAXES, 2)
						.sounds(BlockSoundGroup.STONE));
		FINALLIUM_ORE = new Block(
				FabricBlockSettings.copyOf(Blocks.END_STONE)
						.requiresTool()
						.breakByTool(FabricToolTags.PICKAXES, 2)
						.sounds(BlockSoundGroup.STONE));
		FINALLIUM_BLOCK = new Block(
				FabricBlockSettings.copyOf(Blocks.END_STONE)
						.requiresTool()
						.breakByTool(FabricToolTags.PICKAXES, 2)
						.sounds(BlockSoundGroup.STONE));
		COBALT_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE));
		COBALT_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK));
		RUSTED_IRON_BLOCK = new Block(
				FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
						.requiresTool()
						.breakByTool(FabricToolTags.PICKAXES, 3)
						.sounds(BlockSoundGroup.METAL));
		PHAZED_VOID = new Block(
				FabricBlockSettings.of(PHAZED_VOID_MATERIAL)
						.breakByTool(FabricToolTags.SHEARS)
						.sounds(BlockSoundGroup.GLASS));
		MOLTEN_TOPAZ = new MoltenTopazFluidBlock(FabricBlockSettings.copyOf(Blocks.LAVA));
		FLUID_CAULDRON = new FluidCauldronBlock(
				FabricBlockSettings.copyOf(Blocks.CAULDRON)
						.luminance(state -> state.get(FluidCauldronBlock.FLUID_TYPE).isLit() ? 15 : 0));
		BEACON_OF_UNDYING = new BeaconOfUndyingBlock(FabricBlockSettings.copyOf(Blocks.BEACON));
		ASHEN_ENDSTONE = new Block(
				FabricBlockSettings.copyOf(Blocks.END_STONE)
						.sounds(BlockSoundGroup.STONE)
						.breakByTool(FabricToolTags.PICKAXES,2)
						.luminance(15));
	}
}
