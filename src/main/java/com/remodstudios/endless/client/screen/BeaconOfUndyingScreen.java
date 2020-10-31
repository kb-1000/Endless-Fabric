package com.remodstudios.endless.client.screen;

import com.remodstudios.endless.block.entity.screen.BeaconOfUndyingScreenHandler;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class BeaconOfUndyingScreen extends CottonInventoryScreen<BeaconOfUndyingScreenHandler> {
	public BeaconOfUndyingScreen(BeaconOfUndyingScreenHandler handler, PlayerInventory inv, Text title) {
		super(handler, inv.player, title);
	}

	public BeaconOfUndyingScreen(BeaconOfUndyingScreenHandler handler, PlayerEntity player, Text title) {
		super(handler, player, title);
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}
}
