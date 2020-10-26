package com.remodstudios.endless_fabric.block.entity.screen.widget;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.Texture;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.Identifier;

public class WFgBgBar extends WWidget {
	public static final Texture DEFAULT_BACKGROUND_TEX = new Texture(new Identifier("endless_fabric:textures/screen/widget/bar_bg.png"), 0.0F, 0.0F, 0.5F, 1.0F);
	private PropertyDelegate propertyDelegate;
	private int index;
	private int max;
	private int color;
	private Texture foregroundTexture = new Texture(new Identifier("endless_fabric:textures/screen/widget/green.png"));

	public WFgBgBar(PropertyDelegate propertyDelegate, int index, int max, int color) {
		this.propertyDelegate = propertyDelegate;
		this.index = index;
		this.max = max;
		this.color = color;
	}

	public int getIndex() {
		return this.index;
	}

	public PropertyDelegate getPropertyDelegate() {
		return this.propertyDelegate;
	}

	public WFgBgBar setIndex(int index) {
		this.index = index;
		return this;
	}

	public WFgBgBar setPropertyDelegate(PropertyDelegate propertyDelegate) {
		this.propertyDelegate = propertyDelegate;
		return this;
	}

	public int getMax() {
		return this.max;
	}

	public WFgBgBar setMax(int max) {
		this.max = max;
		return this;
	}

	public WFgBgBar setForegroundTexture(Texture foregroundTexture) {
		this.foregroundTexture = foregroundTexture;
		return this;
	}

	public Texture getForegroundTexture() {
		return this.foregroundTexture;
	}

	public int getColor() {
		return this.color;
	}

	public WFgBgBar setColor(int color) {
		this.color = color;
		return this;
	}

	@Override
	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		int val = this.getPropertyDelegate().get(this.index);
		if (val > 0) {
			ScreenDrawing.coloredRect(x, y, this.getWidth(), this.getHeight() * (val / this.max), this.color);
		}
		ScreenDrawing.texturedRect(x, y, 16, 32, DEFAULT_BACKGROUND_TEX, 0x000000);
		super.paint(matrices, x, y, mouseX, mouseY);
	}
}
