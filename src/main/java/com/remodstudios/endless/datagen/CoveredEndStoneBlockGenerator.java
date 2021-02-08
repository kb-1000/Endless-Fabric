package com.remodstudios.endless.datagen;

import com.remodstudios.yarnandneedles.datagen.generators.block.SimpleBlockGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.util.Identifier;

// ping me if you have a better name - leocth
public class CoveredEndStoneBlockGenerator extends SimpleBlockGenerator {

	public static final CoveredEndStoneBlockGenerator INSTANCE = new CoveredEndStoneBlockGenerator();

	@Override
	protected void generateModels(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
		Identifier blockPath = IdUtils.wrapPath("block/", id);

		pack.addBlockModel(id, model -> model
			.parent(new Identifier("block/cube_bottom_top"))
			.texture("top", IdUtils.wrapPath(blockPath, "_top"))
			.texture("side", IdUtils.wrapPath(blockPath, "_side"))
			.texture("bottom", new Identifier("block/end_stone"))
		);
	}
}
