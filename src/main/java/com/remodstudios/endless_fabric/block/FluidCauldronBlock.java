package com.remodstudios.endless_fabric.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CauldronBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FluidCauldronBlock extends CauldronBlock {
	public static final EnumProperty<FluidType> FLUID_TYPE = EnumProperty.of("fluid", FluidType.class);

	public FluidCauldronBlock(Settings settings) {
		super(settings);
	}

	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		return ActionResult.PASS;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FLUID_TYPE);
		super.appendProperties(builder);
	}

	public enum FluidType implements StringIdentifiable {
		NONE("none", false),
		MOLTEN_TOPAZ("molten_topaz", true);

		private final String name;
		private final boolean lit;

		FluidType(String name, boolean lit) {
			this.name = name;
			this.lit = lit;
		}

		@Override
		public String asString() {
			return this.name;
		}

		public boolean isLit() {
			return this.lit;
		}
	}
}
