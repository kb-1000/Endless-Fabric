package com.remodstudios.endless.datagen;

import com.remodstudios.yarnandneedles.datagen.generators.item.SimpleItemGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.util.IdUtils;
import net.minecraft.util.Identifier;

//TODO add a parent id field to SimpleItemGenerator in YNN - leocth
public class HandheldItemGenerator extends SimpleItemGenerator {
	public static final HandheldItemGenerator INSTANCE = new HandheldItemGenerator();
	@Override
	protected void generateItemModel(ArtificeResourcePack.ClientResourcePackBuilder pack, Identifier id) {
		pack.addItemModel(id, model -> model
			.parent(new Identifier("item/handheld"))
			.texture("layer0", IdUtils.wrapPath("item/", id))
		);
	}
}
