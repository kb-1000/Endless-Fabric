package com.remodstudios.endless.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CobaltMagnetItem extends ToolItem {
	public CobaltMagnetItem(ToolMaterial material, Settings settings) {
		super(material, settings);
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		if (!world.isClient) {
			((ServerWorld) world).getServer().getCommandManager().execute(user.getCommandSource(), "/execute as @p run tp @e[r=10] ~ ~ ~");
		}

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.getAbilities().creativeMode) {
			itemStack.damage(1, user, (e) -> {
				e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
			});
		}

		return TypedActionResult.success(itemStack, world.isClient());
	}
}
