package com.remodstudios.endless_fabric.fluid;

import com.remodstudios.endless_fabric.Endless;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndlessModFluids {
	public static final FlowableFluid FLOWING_MOLTEN_TOPAZ = register(new MoltenTopazFluid.Flowing(), "flowing_molten_topaz");
	public static final FlowableFluid MOLTEN_TOPAZ = register(new MoltenTopazFluid.Still(), "molten_topaz");

	private static <T extends Fluid> T register(T fluid, String name) {
		return Registry.register(Registry.FLUID, new Identifier(Endless.MOD_ID, name), fluid);
	}

	public static void init() {
		// just loads the class
	}
}
