package com.remodstudios.endless_fabric.block;

import java.util.List;

import com.remodstudios.endless_fabric.block.entity.BeaconOfUndyingBlockEntity;
import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class BeaconOfUndyingBlock extends BlockWithEntity implements PropertyDelegateHolder {
	public BeaconOfUndyingBlock(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new BeaconOfUndyingBlockEntity();
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Environment(EnvType.CLIENT)
	@Override
	public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext ctx) {
		super.appendTooltip(stack, world, tooltip, ctx);
		if (ctx.isAdvanced()) {
			tooltip.add(new TranslatableText(this.getTranslationKey() + ".tooltip"));
		}
	}

	@Override
	public PropertyDelegate getPropertyDelegate() {
		return null;
	}
}
