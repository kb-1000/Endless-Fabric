package com.remodstudios.endless_fabric.block.entity.screen;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class BeaconOfUndyingScreenHandler extends SyncedGuiDescription {
	public BeaconOfUndyingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext ctx) {
		super(null, syncId, playerInventory, getBlockInventory(ctx), getBlockPropertyDelegate(ctx));
	}
}
