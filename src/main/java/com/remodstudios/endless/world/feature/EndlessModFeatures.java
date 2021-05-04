package com.remodstudios.endless.world.feature;

import com.remodstudios.endless.Endless;
import org.apache.logging.log4j.Level;

public class EndlessModFeatures {
	/* FIXME refactor to use FAPI Biome API -ADCLeo
    public static final ConfiguredFeature<?, ?> TOPAZ_ORE = register("topaz_ore", Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), EndlessModBlocks.INSTANCE.TOPAZ_ORE.getDefaultState(), 8)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 100))).repeat(6));
    public static final ConfiguredFeature<?, ?> FINALLIUM_ORE = register("finallium_ore", Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), EndlessModBlocks.INSTANCE.FINALLIUM_ORE.getDefaultState(), 8)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 100))).repeat(6));

    public static ConfiguredFeature<?, ?> register(String name, ConfiguredFeature<?, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Endless.id(name), feature);
    }
            
    public static void init() {
        BuiltinRegistries.BIOME.stream()
                               .filter(biome -> biome.getCategory().equals(Biome.Category.THEEND))
                               .forEach(biome -> {
                                   final List<List<Supplier<ConfiguredFeature<?, ?>>>> features  = new ArrayList<>(biome.getGenerationSettings().getFeatures());
                                   List<Supplier<ConfiguredFeature<?, ?>>> ores;
                                   try {
                                       ores = new ArrayList<>(features.get(GenerationStep.Feature.UNDERGROUND_ORES.ordinal()));
                                   } catch (RuntimeException e) {
                                       ores = new ArrayList<>();
                                   }
                                   try {
                                       features.set(GenerationStep.Feature.UNDERGROUND_ORES.ordinal(), ores);
                                   } catch (RuntimeException e) {
                                       while (features.size() < GenerationStep.Feature.UNDERGROUND_ORES.ordinal()) {
                                           features.add(ImmutableList.of());
                                       }
                                       features.add(GenerationStep.Feature.UNDERGROUND_ORES.ordinal(), ores);
                                   }
                                   ores.add(() -> TOPAZ_ORE);
                                   ores.add(() -> FINALLIUM_ORE);
                                   ((GenerationSettingsAccessor) biome.getGenerationSettings()).setFeatures(features);
                               });
    }
	 */

	// temp init method
	public static void init() {
		Endless.log(Level.WARN, "World generation features are NYI!");
	}
}
