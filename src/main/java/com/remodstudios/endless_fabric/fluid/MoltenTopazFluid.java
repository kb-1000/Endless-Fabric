package com.remodstudios.endless_fabric.fluid;

import java.util.Random;

import com.remodstudios.endless_fabric.block.EndlessModBlocks;
import com.remodstudios.endless_fabric.item.EndlessModItems;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public abstract class MoltenTopazFluid extends FlowableFluid {
	@Override
	public Fluid getFlowing() {
		return EndlessModFluids.FLOWING_MOLTEN_TOPAZ;
	}

	@Override
	public Fluid getStill() {
		return EndlessModFluids.MOLTEN_TOPAZ;
	}

	@Override
	public Item getBucketItem() {
		return EndlessModItems.MOLTEN_TOPAZ_BUCKET;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
	}

	@Override
	public void onRandomTick(World world, BlockPos pos, FluidState state, Random random) {
	}

	@Override
	protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
	}

	@Override
	public int getFlowSpeed(WorldView world) {
		return world.getDimension().isUltrawarm() ? 4 : 2;
	}

	@Override
	public BlockState toBlockState(FluidState state) {
		return EndlessModBlocks.MOLTEN_TOPAZ.getDefaultState().with(FluidBlock.LEVEL, state.isStill() ? 0 : 8 - Math.min(state.getLevel(), 8) + (state.get(FALLING) ? 8 : 0));
	}

	@Override
	public boolean matchesType(Fluid fluid) {
		return fluid instanceof MoltenTopazFluid;
	}

	@Override
	public int getLevelDecreasePerBlock(WorldView world) {
		return world.getDimension().isUltrawarm() ? 1 : 2;
	}

	@Override
	public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
		return state.getHeight(world, pos) >= 0.44444445F && fluid.isIn(FluidTags.WATER);
	}

	@Override
	public int getTickRate(WorldView world) {
		return world.getDimension().isUltrawarm() ? 10 : 30;
	}

	@Override
	public int getNextTickDelay(World world, BlockPos pos, FluidState first, FluidState second) {
		int tickDelay = this.getTickRate(world);

		if (!first.isEmpty() && !second.isEmpty() && !first.get(FALLING) && !second.get(FALLING) && second.getHeight(world, pos) > first.getHeight(world, pos) && world.getRandom().nextInt(4) != 0) {
			tickDelay *= 4;
		}

		return tickDelay;
	}

	@Override
	protected boolean isInfinite() {
		return false;
	}

	@Override
	protected boolean hasRandomTicks() {
		return true;
	}

	@Override
	protected float getBlastResistance() {
		return 100000;
	}

	public static class Flowing extends MoltenTopazFluid {
		@Override
		protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
			super.appendProperties(builder);
			builder.add(LEVEL);
		}

		@Override
		public int getLevel(FluidState state) {
			return state.get(LEVEL);
		}

		@Override
		public boolean isStill(FluidState state) {
			return false;
		}
	}

	public static class Still extends MoltenTopazFluid {
		@Override
		public int getLevel(FluidState state) {
			return 8;
		}

		@Override
		public boolean isStill(FluidState state) {
			return true;
		}
	}
}
