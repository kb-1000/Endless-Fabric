package com.remodstudios.endless.client;

import com.remodstudios.endless.block.entity.screen.EndlessModScreenHandlerTypes;

import net.fabricmc.api.ClientModInitializer;

public class EndlessClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
		FluidRenderHelper.initAll();
		EndlessModScreenHandlerTypes.initClient();
    }
}
