package com.remodstudios.endless.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public final class EndlessBlockMaterials {
	public static final Material PHASED_VOID =
		new FabricMaterialBuilder(MapColor.BLUE).notSolid().allowsMovement().build();
}
