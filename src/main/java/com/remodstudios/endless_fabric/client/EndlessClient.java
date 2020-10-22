package com.remodstudios.endless_fabric.client;

import net.fabricmc.api.ClientModInitializer;

public class EndlessClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
		FluidRenderHelper.MOLTEN_TOPAZ.init();
    }
}
