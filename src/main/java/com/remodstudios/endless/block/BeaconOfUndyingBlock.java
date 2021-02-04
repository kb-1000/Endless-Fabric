package com.remodstudios.endless.block;

import java.util.List;

import com.remodstudios.endless.block.entity.BeaconOfUndyingBlockEntity;
import net.minecraft.block.*;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class BeaconOfUndyingBlock extends Block implements BlockEntityProvider {
	public BeaconOfUndyingBlock(Settings settings) {
		super(settings);
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
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
		return ActionResult.SUCCESS;
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new BeaconOfUndyingBlockEntity();
	}
}
