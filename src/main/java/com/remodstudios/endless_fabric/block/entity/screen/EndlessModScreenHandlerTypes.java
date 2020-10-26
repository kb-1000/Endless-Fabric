package com.remodstudios.endless_fabric.block.entity.screen;

import com.remodstudios.endless_fabric.Endless;
import com.remodstudios.endless_fabric.client.screen.BeaconOfUndyingScreen;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;

public class EndlessModScreenHandlerTypes {
	public static final ScreenHandlerType<? extends BeaconOfUndyingScreenHandler> BEACON_OF_UNDYING = register((syncId, inventory) -> new BeaconOfUndyingScreenHandler(syncId, inventory, ScreenHandlerContext.EMPTY), "beacon_of_undying");

	private static <T extends ScreenHandler> ScreenHandlerType<? extends T> register(ScreenHandlerRegistry.SimpleClientHandlerFactory<T> factory, String name) {
		return ScreenHandlerRegistry.registerSimple(new Identifier(Endless.MOD_ID, name), factory);
	}

	public static void init() {

	}

	// IMPORTANT:
	// Do not remove this suppression.
	// This is to prevent issues with inferring generic types.
	@SuppressWarnings("RedundantTypeArguments")
	public static void initClient() {
		ScreenRegistry.<BeaconOfUndyingScreenHandler, BeaconOfUndyingScreen>register(BEACON_OF_UNDYING, BeaconOfUndyingScreen::new);
	}
}
