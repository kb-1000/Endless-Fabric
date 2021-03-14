package com.remodstudios.endless.item;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class CobaltMagnetItem extends ToolItem {
	public CobaltMagnetItem(ToolMaterial material, Settings settings) {
		super(material, settings);
	}
	
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		Vec3d pos = user.getPos();
		List<ItemEntity> entities = user.getEntityWorld().getEntitiesByClass(
				ItemEntity.class,
				new Box(
						pos.getX() - 10, pos.getY() - 10, pos.getZ() - 10,
						pos.getX() + 10, pos.getY() + 10, pos.getZ() + 10
				), (entity) -> true
		);
		if (!world.isClient) {
			for (ItemEntity entity : entities) {
				if (pos.distanceTo(entity.getPos()) <= 10) {
					entity.setPosition(pos.getX(), pos.getY(), pos.getZ());
				}
			}
		}
		
		if (entities.isEmpty())
			return TypedActionResult.pass(itemStack);
		if (user.world.isClient)
			return TypedActionResult.success(itemStack);
		
		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.getAbilities().creativeMode) {
			itemStack.damage(1, user, (e) -> {
				e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
			});
		}
		
		return TypedActionResult.success(itemStack, world.isClient());
	}
}
