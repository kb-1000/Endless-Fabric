package com.remodstudios.endless.fluid;

import java.util.Set;

import com.google.common.collect.Sets;
import com.remodstudios.endless.Endless;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndlessModFluids {
	public static final Set<Fluid> CAULDRON_FLUIDS = new ObjectLinkedOpenHashSet<>();
	public static final FlowableFluid FLOWING_MOLTEN_TOPAZ = new MoltenTopazFluid.Flowing();
	public static final FlowableFluid MOLTEN_TOPAZ = new MoltenTopazFluid.Still();

	private static void register(Fluid fluid, String name) {
		// TODO: is it safe to assume that there always two fluids registered?
		if (fluid.isStill(fluid.getDefaultState())) {
			CAULDRON_FLUIDS.add(fluid);
		}
		Registry.register(Registry.FLUID, Endless.id(name), fluid);
	}

	public static void init() {
		register(FLOWING_MOLTEN_TOPAZ, "flowing_molten_topaz");
		register(MOLTEN_TOPAZ, "molten_topaz");
	}
}
