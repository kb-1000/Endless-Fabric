package com.remodstudios.endless.datagen;

import com.remodstudios.yarnandneedles.datagen.generators.block.SimpleBlockGenerator;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import net.minecraft.util.Identifier;

public class ItemlessBlockGenerator extends SimpleBlockGenerator {
	public static final ItemlessBlockGenerator INSTANCE = new ItemlessBlockGenerator();
	@Override
	protected void generateLootTable(ArtificeResourcePack.ServerResourcePackBuilder pack, Identifier id) {
		// no-op
	}
}
