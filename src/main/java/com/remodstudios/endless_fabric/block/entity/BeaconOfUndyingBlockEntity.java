package com.remodstudios.endless_fabric.block.entity;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class BeaconOfUndyingBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
	private Text customName = new TranslatableText("screen_handler.endless.beacon_of_undying");

	public BeaconOfUndyingBlockEntity() {
		super(EndlessModBlockEntityTypes.BEACON_OF_UNDYING);
	}

	@Override
	public Text getDisplayName() {
		return this.customName;
	}

	public void setCustomName(Text text) {
		this.customName = text;
	}

	@Override
	public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
		return null;
	}
}
