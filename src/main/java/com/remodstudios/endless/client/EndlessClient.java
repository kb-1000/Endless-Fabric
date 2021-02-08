package com.remodstudios.endless.client;

import com.remodstudios.endless.Endless;
import com.remodstudios.endless.block.EndlessModBlocks;
import com.remodstudios.endless.item.EndlessModItems;
import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ClientModInitializer;

import java.io.IOException;

public class EndlessClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
		FluidRenderHelper.initAll();

		Artifice.registerAssetPack(Endless.id("artifice_rp"), pack -> {
			EndlessModItems.INSTANCE.generateAssets(pack);
			EndlessModBlocks.INSTANCE.generateAssets(pack);

			try {
				pack.dumpResources("artifice.dbg", "assets");
			} catch (IOException ioe) {
				Endless.LOGGER.error("BRUH! Artifice failed to dump!");
				ioe.printStackTrace();
			}
		});
	}
}
