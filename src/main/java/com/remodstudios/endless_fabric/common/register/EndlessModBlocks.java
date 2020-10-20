package com.remodstudios.endless_fabric.common.register;

import com.remodstudios.endless_fabric.Endless;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.END_STONE;

/**
 * A class handling registration and definition of Endless' blocks.
 *
 * @author LePichu
 */
public final class EndlessModBlocks {
    public static final Block TOPAZ_ORE;

    static {
        TOPAZ_ORE = new Block(FabricBlockSettings.copyOf(END_STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    }

    private EndlessModBlocks() {
    }

    /**
     * Registers all of the mod's blocks.
     */
    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Endless.MOD_ID, "topaz_ore"), TOPAZ_ORE);
    }
}
