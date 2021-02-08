package com.remodstudios.endless.block.entity;

import com.remodstudios.endless.Endless;
import com.remodstudios.endless.block.EndlessModBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndlessModBlockEntityTypes {
	public static final BlockEntityType<BeaconOfUndyingBlockEntity> BEACON_OF_UNDYING =
			FabricBlockEntityTypeBuilder
					.create(BeaconOfUndyingBlockEntity::new, EndlessModBlocks.INSTANCE.BEACON_OF_UNDYING)
					.build(null);

	private static <T extends BlockEntity> BlockEntityType<T> register(BlockEntityType<T> type, String name) {
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, Endless.id(name), type);
	}

	public static void init() {
		register(BEACON_OF_UNDYING, "beacon_of_undying");
	}
}
