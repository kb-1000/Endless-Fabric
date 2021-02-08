package com.remodstudios.endless.block;

import com.remodstudios.endless.Endless;
import com.remodstudios.endless.datagen.CoveredEndStoneBlockGenerator;
import com.remodstudios.yarnandneedles.blocks.BlockRegistry;
import com.remodstudios.yarnandneedles.datagen.ResourceGenerators;
import com.swordglowsblue.artifice.api.util.Processor;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;

@SuppressWarnings("unused")
public class EndlessModBlocks extends BlockRegistry {
	public static final EndlessModBlocks INSTANCE = new EndlessModBlocks();

	//region Block declarations
	public final Block TOPAZ_ORE = add("topaz_ore", newStonelike());
	public final Block TOPAZ_BLOCK = add("topaz_block", newStonelike());
    public final Block FINALLIUM_ORE = add("finallium_ore", newStonelike());
	public final Block FINALLIUM_BLOCK = add("finallium_block", newStonelike());
	public final Block COBALT_ORE = add("cobalt_ore", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));
	public final Block COBALT_BLOCK = add("cobalt_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
    public final Block RUSTED_IRON_BLOCK =
			add("rusted_iron_block", new Block(
				FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
					.requiresTool()
					.breakByTool(FabricToolTags.PICKAXES, 3)
					.sounds(BlockSoundGroup.METAL))
			);
    public final Block PHAZED_VOID =
			add("phazed_void", new Block(
				FabricBlockSettings.of(EndlessBlockMaterials.PHAZED_VOID)
					.breakByTool(FabricToolTags.SHEARS)
					.sounds(BlockSoundGroup.GLASS))
			);
    public final Block MOLTEN_TOPAZ =
			add("molten_topaz",
				RegistrySettings.of(ResourceGenerators.NO_OP),
				new MoltenTopazFluidBlock(FabricBlockSettings.copyOf(Blocks.LAVA))
			);
    public final Block FLUID_CAULDRON =
			add("fluid_cauldron", new FluidCauldronBlock(
				FabricBlockSettings.copyOf(Blocks.CAULDRON)
					.luminance(state -> state.get(FluidCauldronBlock.FLUID_TYPE).isLit() ? 15 : 0)
			));
    public final Block BEACON_OF_UNDYING =
			add("beacon_of_undying", new BeaconOfUndyingBlock(FabricBlockSettings.copyOf(Blocks.BEACON)));
    public final Block ASHEN_ENDSTONE =
			add("ashen_endstone",
				RegistrySettings.of(CoveredEndStoneBlockGenerator.INSTANCE),
				newStonelike(settings -> settings
					.luminance(15)
				)
			);
	public final Block CRYSTILLIUM =
			add("crystillium",
				RegistrySettings.of(CoveredEndStoneBlockGenerator.INSTANCE),
				newStonelike(settings -> settings
					.luminance(15)
				)
			);
	public final Block PURPUR_GRASS =
			add("purpur_grass",
				RegistrySettings.of(CoveredEndStoneBlockGenerator.INSTANCE),
				newStonelike(settings -> settings
						.luminance(15)
				)
			);
	public final Block TEALITE =
			add("tealite",
				RegistrySettings.of(CoveredEndStoneBlockGenerator.INSTANCE),
				newStonelike(settings -> settings
						.luminance(15)
				)
			);
	public final Block RHYOLITE = add("rhyolite", newStonelike());
	public final Block POLISHED_RHYOLITE = add("polished_rhyolite", newStonelike());

	public EndlessModBlocks() {
		super(Endless.MOD_ID);
	}

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
