package com.remodstudios.endless_fabric.common.register;

import com.remodstudios.endless_fabric.Endless;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.END_STONE;

/**
 * A class handling registration and definition of Endless' blocks.
 *
 * @author YTG1234
 * @author LePichu
 */
public final class EndlessModBlocks {
    public static final Block TOPAZ_ORE;
    public static final Block FINALLIUM_ORE;

    static {
        TOPAZ_ORE = new Block(FabricBlockSettings.copyOf(END_STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
        FINALLIUM_ORE = new Block(FabricBlockSettings.copyOf(END_STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    }

    private EndlessModBlocks() {
    }

    /**
     * Registers all of the mod's blocks.
     */
    public static void registerBlocks() {
        //blocks
        Registry.register(Registry.BLOCK, new Identifier(Endless.MOD_ID, "topaz_ore"), TOPAZ_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Endless.MOD_ID,"finallium_ore"), FINALLIUM_ORE);
        //blockitems
        Registry.register(Registry.ITEM, new Identifier(Endless.MOD_ID, "topaz_ore"), new BlockItem(TOPAZ_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Endless.MOD_ID, "finallium_ore"), new BlockItem(FINALLIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
