package com.remodstudios.endless_fabric.block.entity.screen;

import com.remodstudios.endless_fabric.Endless;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;

public class EndlessModScreenHandlerTypes {
	public static final ScreenHandlerType<?> BEACON_OF_UNDYING = register((syncId, inventory) -> new BeaconOfUndyingScreenHandler(syncId, inventory, ScreenHandlerContext.EMPTY), "beacon_of_undying");

	private static ScreenHandlerType<?> register(ScreenHandlerRegistry.SimpleClientHandlerFactory<? extends ScreenHandler> factory, String name) {
		return ScreenHandlerRegistry.registerSimple(new Identifier(Endless.MOD_ID, name), factory);
	}


	public static void init() {

	}

	// TODO
	public static void initClient() {
		ScreenRegistry.register(BEACON_OF_UNDYING, (handler, inventory, text) -> {
			return null;
		});
	}
}
