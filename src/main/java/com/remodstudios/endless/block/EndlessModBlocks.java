package com.remodstudios.endless.block;

import com.remodstudios.endless.Endless;
import com.remodstudios.yarnandneedles.blocks.BlockRegistry;
import com.remodstudios.yarnandneedles.datagen.ResourceGenerators;
import com.swordglowsblue.artifice.api.util.Processor;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;

@SuppressWarnings("unused")
public class EndlessModBlocks extends BlockRegistry {
	public static final EndlessModBlocks INSTANCE = new EndlessModBlocks();

	//region Block declarations

	public EndlessModBlocks() {
		super(Endless.MOD_ID);
	}

	public final Block BEACON_OF_UNDYING = add("beacon_of_undying",
			RegistrySettings.of(ResourceGenerators.SIMPLE_BLOCK, RenderLayer.getCutout()),
			newStonelike());

	//endregion
	private static Block newStonelike() {
		return new Block(
				FabricBlockSettings.copyOf(Blocks.END_STONE)
						.requiresTool()
						.breakByTool(FabricToolTags.PICKAXES, 2)
						.sounds(BlockSoundGroup.STONE));
	}
	private static Block newStonelike(Processor<FabricBlockSettings> settings) {
		return new Block(settings.process(
				FabricBlockSettings.copyOf(Blocks.END_STONE)
						.requiresTool()
						.breakByTool(FabricToolTags.PICKAXES, 2)
						.sounds(BlockSoundGroup.STONE)
		));
	}
	//endregion
}
