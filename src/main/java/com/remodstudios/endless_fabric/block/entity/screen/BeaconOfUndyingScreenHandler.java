package com.remodstudios.endless_fabric.block.entity.screen;

import com.remodstudios.endless_fabric.block.entity.screen.widget.WFgBgBar;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerContext;

public class BeaconOfUndyingScreenHandler extends SyncedGuiDescription {
	public BeaconOfUndyingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext ctx) {
		super(EndlessModScreenHandlerTypes.BEACON_OF_UNDYING, syncId, playerInventory, getBlockInventory(ctx), getBlockPropertyDelegate(ctx));
		WGridPanel root = new WGridPanel();
		this.setRootPanel(root);

		WItemSlot paymentSlot = WItemSlot.of(this.blockInventory, 0).setFilter(stack -> stack.getItem() == Items.TOTEM_OF_UNDYING);
		root.add(paymentSlot, 1, 2);

		WFgBgBar bar = new WFgBgBar(this.propertyDelegate, 1, 4, 0xAAFFAA);
		bar.setSize(32, 16);
		root.add(bar, 3, 1);

		root.validate(this);
	}
}
