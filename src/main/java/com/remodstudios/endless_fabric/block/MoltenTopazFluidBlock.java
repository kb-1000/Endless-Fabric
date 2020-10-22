package com.remodstudios.endless_fabric.block;

import com.remodstudios.endless_fabric.fluid.EndlessModFluids;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoltenTopazFluidBlock extends FluidBlock {
	protected MoltenTopazFluidBlock(Settings settings) {
		super(EndlessModFluids.MOLTEN_TOPAZ, settings);
	}

	// TODO
	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		super.onEntityCollision(state, world, pos, entity);
	}
}
