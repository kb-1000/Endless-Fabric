package com.remodstudios.endless.block;

import com.remodstudios.endless.Endless;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

public class EndlessModBlocks {
    public static final Block TOPAZ_ORE = register(new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.STONE)), "topaz_ore");
    public static final Block FINALLIUM_ORE = register(new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.STONE)), "finallium_ore");
    public static final Block RUSTED_IRON_BLOCK = register(new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL)), "rusted_iron_block");
    public static final Block PHAZED_VOID = register(new Block(FabricBlockSettings.of(new FabricMaterialBuilder(MaterialColor.BLUE_TERRACOTTA).notSolid().allowsMovement().build()).breakByTool(FabricToolTags.SHEARS).sounds(BlockSoundGroup.GLASS)), "phazed_void");
    public static final Block TOPAZ_BLOCK = register(new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.STONE)),"topaz_block");
    public static final Block MOLTEN_TOPAZ = register(new MoltenTopazFluidBlock(FabricBlockSettings.copyOf(Blocks.LAVA)), "molten_topaz");
    public static final Block FLUID_CAULDRON = register(new FluidCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON).lightLevel(state -> {
    	if (state.get(FluidCauldronBlock.FLUID_TYPE).isLit()) {
			return 15;
		}
    	return 0;
	})), "fluid_cauldron");
    public static final Block BEACON_OF_UNDYING = register(new BeaconOfUndyingBlock(FabricBlockSettings.copyOf(Blocks.BEACON)), "beacon_of_undying");
	public static final Block ASHEN_ENDSTONE = register(new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES,2).lightLevel(state -> {return 15;})), "ashen_endstone");
	public static final Block FINALLIUM_BLOCK = register(new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.STONE)), "finallium_block");

    private static Block register(Block block, String name) {
        return Registry.register(Registry.BLOCK, new Identifier(Endless.MOD_ID, name), block);
    }

    public static void init() {
        // just loads the class

    }
}
