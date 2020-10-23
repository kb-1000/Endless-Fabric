package com.remodstudios.endless_fabric.block;

import com.remodstudios.endless_fabric.block.entity.BeaconOfUndyingBlockEntity;

import net.minecraft.block.BeaconBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BeaconOfUndyingBlock extends BeaconBlock {
	public BeaconOfUndyingBlock(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new BeaconOfUndyingBlockEntity();
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
		if (itemStack.hasCustomName()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof BeaconOfUndyingBlockEntity) {
				((BeaconOfUndyingBlockEntity) blockEntity).setDisplayName(itemStack.getName());
			}
		}
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) {
			return ActionResult.SUCCESS;
		} else {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof BeaconOfUndyingBlockEntity) {
				player.openHandledScreen((BeaconOfUndyingBlockEntity) blockEntity);
				player.incrementStat(Stats.INTERACT_WITH_BEACON);
			}

			return ActionResult.CONSUME;
		}
	}
}
