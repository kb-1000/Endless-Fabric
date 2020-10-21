package com.remodstudios.endless_fabric.world.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.remodstudios.endless_fabric.Endless;
import com.remodstudios.endless_fabric.block.EndlessModBlocks;
import com.remodstudios.endless_fabric.mixin.GenerationSettingsAccessor;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class EndlessModFeatures {
    public static final ConfiguredFeature<?, ?> TOPAZ_ORE = register("topaz_ore", Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), EndlessModBlocks.TOPAZ_ORE.getDefaultState(), 8)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 100))).repeat(6));
    public static final ConfiguredFeature<?, ?> FINALLIUM_ORE = register("finallium_ore", Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), EndlessModBlocks.FINALLIUM_ORE.getDefaultState(), 8)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 100))).repeat(6));

    public static ConfiguredFeature<?, ?> register(String name, ConfiguredFeature<?, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Endless.MOD_ID, name), feature);
    }
            
    public static void init() {
        BuiltinRegistries.BIOME.stream()
                               .filter(biome -> biome.getCategory().equals(Biome.Category.THEEND))
                               .forEach(biome -> {
                                   List<List<Supplier<ConfiguredFeature<?, ?>>>> features  = new ArrayList<>(biome.getGenerationSettings().getFeatures());
                                   List<Supplier<ConfiguredFeature<?, ?>>> ores = new ArrayList<>(features.get(GenerationStep.Feature.UNDERGROUND_ORES.ordinal()));
                                   features.set(GenerationStep.Feature.UNDERGROUND_ORES.ordinal(), ores);
                                   ores.add(() -> TOPAZ_ORE);
                                   ores.add(() -> FINALLIUM_ORE);
                                   ((GenerationSettingsAccessor) biome.getGenerationSettings()).setFeatures(features);
                               });
    }
}
