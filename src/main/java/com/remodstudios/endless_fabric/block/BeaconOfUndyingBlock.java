package com.remodstudios.endless_fabric.block;

import java.util.Optional;
import java.util.stream.Stream;

import com.remodstudios.endless_fabric.block.entity.BeaconOfUndyingBlockEntity;
import com.remodstudios.endless_fabric.item.EndlessModItems;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;

public class BeaconOfUndyingBlock extends BlockWithEntity {
	public BeaconOfUndyingBlock(Settings settings) {
		super(settings);
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockView world) {
		return new BeaconOfUndyingBlockEntity();
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockHitResult result) {
		ItemStack itemStack = playerEntity.getStackInHand(hand);
		if (hand == Hand.MAIN_HAND && !isChargeItem(itemStack) && isChargeItem(playerEntity.getStackInHand(Hand.OFF_HAND))) {
			return ActionResult.PASS;
		} else if (isChargeItem(itemStack) && state.get(Properties.CHARGES) < 4) {
			world.setBlockState(pos, state.with(Properties.CHARGES, (Integer)state.get(Properties.CHARGES) + 1), 3);
			world.playSound(null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 1.0F, 1.0F);
			if (!playerEntity.abilities.creativeMode) {
				itemStack.decrement(1);
			}

			return ActionResult.success(world.isClient);
		} else if (state.get(Properties.CHARGES) == 0) {
			return ActionResult.PASS;
		} else if (!(world.getRegistryKey() == World.END)) {
			if (!world.isClient) {
				this.explode(world, pos);
			}

			return ActionResult.success(world.isClient);
		} else {
			if (!world.isClient) {
				ServerPlayerEntity player = (ServerPlayerEntity)playerEntity;
				if (player.getSpawnPointDimension() != world.getRegistryKey() || !player.getSpawnPointPosition().equals(pos)) {
					player.setSpawnPoint(world.getRegistryKey(), pos, 0.0F, false, true);
					world.playSound(null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_RESPAWN_ANCHOR_SET_SPAWN, SoundCategory.BLOCKS, 1.0F, 1.0F);
					return ActionResult.SUCCESS;
				}
			}

			return ActionResult.CONSUME;
		}
	}

	private void explode(World world, final BlockPos explodedPos) {
		world.removeBlock(explodedPos, false);
		Stream<Direction> stream = Direction.Type.HORIZONTAL.stream();
		boolean bl = stream.map(explodedPos::offset).anyMatch((pos) -> {
			FluidState fluidState = world.getFluidState(pos);
			if (!fluidState.isIn(FluidTags.WATER)) {
				return false;
			} else if (fluidState.isStill()) {
				return true;
			} else {
				float f = (float)fluidState.getLevel();
				if (f < 2.0F) {
					return false;
				} else {
					FluidState fluidState2 = world.getFluidState(pos.down());
					return !fluidState2.isIn(FluidTags.WATER);
				}
			}
		});
		final boolean bl2 = bl || world.getFluidState(explodedPos.up()).isIn(FluidTags.WATER);
		ExplosionBehavior explosionBehavior = new ExplosionBehavior() {
			public Optional<Float> getBlastResistance(Explosion explosion, BlockView world, BlockPos pos, BlockState blockState, FluidState fluidState) {
				return pos.equals(explodedPos) && bl2 ? Optional.of(Blocks.WATER.getBlastResistance()) : super.getBlastResistance(explosion, world, pos, blockState, fluidState);
			}
		};
		world.createExplosion(null, DamageSource.badRespawnPoint(), explosionBehavior, explodedPos.getX() + 0.5D, explodedPos.getY() + 0.5D, explodedPos.getZ() + 0.5D, 5.0F, true, Explosion.DestructionType.DESTROY);
	}

	private static boolean isChargeItem(ItemStack stack) {
		return stack.getItem().isIn(EndlessModItems.Tags.BEACON_OF_UNDYING_PAYMENT_ITEMS);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(Properties.CHARGES);
		super.appendProperties(builder);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
}
