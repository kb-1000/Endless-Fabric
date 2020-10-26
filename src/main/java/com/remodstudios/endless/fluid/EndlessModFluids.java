package com.remodstudios.endless.fluid;

import java.util.Set;

import com.google.common.collect.Sets;
import com.remodstudios.endless.Endless;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndlessModFluids {
	public static final Set<Fluid> CAULDRON_FLUIDS = Sets.newHashSet();
	public static final FlowableFluid FLOWING_MOLTEN_TOPAZ = register(new MoltenTopazFluid.Flowing(), "flowing_molten_topaz");
	public static final FlowableFluid MOLTEN_TOPAZ = register(new MoltenTopazFluid.Still(), "molten_topaz");

	private static <T extends Fluid> T register(T fluid, String name) {
		// TODO: is it safe to assume that there always two fluids registered?
		if (fluid.isStill(fluid.getDefaultState())) {
			CAULDRON_FLUIDS.add(fluid);
		}
		return Registry.register(Registry.FLUID, new Identifier(Endless.MOD_ID, name), fluid);
	}

	public static void init() {
		// just loads the class
	}
}
