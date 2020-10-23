package com.remodstudios.endless_fabric.client;

import com.remodstudios.endless_fabric.block.entity.screen.EndlessModScreenHandlerTypes;

import net.fabricmc.api.ClientModInitializer;

public class EndlessClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
		FluidRenderHelper.MOLTEN_TOPAZ.init();
		EndlessModScreenHandlerTypes.initClient();
    }
}
