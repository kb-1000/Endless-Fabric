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
	private Text displayName = new TranslatableText("block.endless_fabric.beacon_of_undying\"");

	public BeaconOfUndyingBlockEntity() {
		super(EndlessModBlockEntityTypes.BEACON_OF_UNDYING);
	}

	@Override
	public Text getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(Text text) {
		this.displayName = text;
	}

	@Override
	public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
		return null;
	}
}
