package com.remodstudios.endless_fabric.block.entity;

import com.remodstudios.endless_fabric.Endless;
import com.remodstudios.endless_fabric.block.EndlessModBlocks;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndlessModBlockEntityTypes {
	public static final BlockEntityType<BeaconOfUndyingBlockEntity> BEACON_OF_UNDYING = register(BlockEntityType.Builder.create(BeaconOfUndyingBlockEntity::new, EndlessModBlocks.BEACON_OF_UNDYING).build(null), "beacon_of_undying");

	private static <T extends BlockEntity> BlockEntityType<T> register(BlockEntityType<T> type, String name) {
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Endless.MOD_ID, name), type);
	}

	public static void init() {
		// just loads the class
	}
}
