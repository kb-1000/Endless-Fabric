package com.remodstudios.endless.item;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;

public class RecordItem extends MusicDiscItem {
	protected RecordItem(int comparatorOutput, SoundEvent sound, Settings settings) {
		super(comparatorOutput, sound, settings);
	}
}
