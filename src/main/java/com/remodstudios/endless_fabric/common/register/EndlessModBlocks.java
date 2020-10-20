package com.remodstudios.endless_fabric.common.register;

import com.remodstudios.endless_fabric.Endless;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.END_STONE;

public final class EndlessModBlocks {
    //instances
    public static final Block TOPAZ_ORE = new Block(FabricBlockSettings.copyOf(END_STONE));

    //block settings

    public static void registerBlocks () {
        //registry
        Registry.register(Registry.BLOCK, new Identifier(Endless.MOD_ID, "topaz_ore"),TOPAZ_ORE);
    }
}
