package com.remodstudios.endless.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;

public class BeaconOfUndyingBlockEntity extends BlockEntity {
	private int charge;

	public BeaconOfUndyingBlockEntity(BlockPos pos, BlockState state) {
		super(EndlessModBlockEntityTypes.BEACON_OF_UNDYING, pos, state);
	}

	@Override
	public void fromTag(CompoundTag tag) {
		this.charge = tag.getInt("charge");
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		tag.putInt("charge", this.charge);
		return tag;
	}
}
