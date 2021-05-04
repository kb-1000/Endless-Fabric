package com.remodstudios.endless.world.feature;

import com.remodstudios.endless.block.EndlessModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class EndlessModFeatures {
	@SuppressWarnings("SameParameterValue")
	private static void addEndOre(Block block, int size, int bottomOffset, int topOffset, int maximum, int count) {
		RegistryKey<ConfiguredFeature<?, ?>> key = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
				Registry.BLOCK.getId(block));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), Feature.ORE
				.configure(new OreFeatureConfig(
						new BlockMatchRuleTest(Blocks.END_STONE), block.getDefaultState(), size))
				.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(bottomOffset, topOffset, maximum)))
				.spreadHorizontally()
				.repeat(count));
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, key);
	}

	public static void init() {
		addEndOre(EndlessModBlocks.INSTANCE.TOPAZ_ORE, 8, 0, 0, 100, 6);
		addEndOre(EndlessModBlocks.INSTANCE.FINALLIUM_ORE, 8, 0, 0, 100, 6);
	}
}
