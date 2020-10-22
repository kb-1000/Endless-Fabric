package com.remodstudios.endless_fabric.block;

import com.remodstudios.endless_fabric.Endless;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.MaterialColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.END_STONE;
import static net.minecraft.block.Blocks.IRON_BLOCK;

public class EndlessModBlocks {
    public static final Block TOPAZ_ORE = register(new Block(FabricBlockSettings.copyOf(END_STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2)), "topaz_ore");
    public static final Block FINALLIUM_ORE = register(new Block(FabricBlockSettings.copyOf(END_STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2)), "finallium_ore");
    public static final Block RUSTED_IRON_BLOCK = register(new Block(FabricBlockSettings.copyOf(IRON_BLOCK).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3)),"rusted_iron_block");
    public static final Block PHAZED_VOID = register(new Block(FabricBlockSettings.of(new FabricMaterialBuilder(MaterialColor.BLUE_TERRACOTTA).notSolid().allowsMovement().build()).breakByTool(FabricToolTags.SHEARS)), "phazed_void");

    private static Block register(Block block, String name) {
        return Registry.register(Registry.BLOCK, new Identifier(Endless.MOD_ID, name), block);
    }

    public static void init() {
        // just loads the class
    }
}
