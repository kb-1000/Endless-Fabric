package com.remodstudios.endless_fabric.block.entity;

import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;

public class BeaconOfUndyingBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, PropertyDelegateHolder, BlockEntityClientSerializable {
	private int charge;
	private final PropertyDelegate propertyDelegate = new PropertyDelegateImpl();

	private Text displayName = new TranslatableText("block.endless_fabric.beacon_of_undying");

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

	@Override
	public PropertyDelegate getPropertyDelegate() {
		return this.propertyDelegate;
	}

	public void deserialize(CompoundTag tag) {
		this.charge = tag.getInt("charge");
		this.setDisplayName(Text.Serializer.fromJson(tag.getString("displayName")));
		super.fromTag(this.getCachedState(), tag);
	}

	public CompoundTag serialize(CompoundTag tag) {
		tag.putInt("charge", this.charge);
		tag.putString("displayName", Text.Serializer.toJson(this.displayName));
		return super.toTag(tag);
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		super.fromTag(state, tag);
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		return super.toTag(tag);
	}

	@Override
	public void fromClientTag(CompoundTag tag) {
		this.deserialize(tag);
	}

	@Override
	public CompoundTag toClientTag(CompoundTag tag) {
		return this.serialize(tag);
	}

	public class PropertyDelegateImpl implements PropertyDelegate {
		private PropertyDelegateImpl() {
		}

		@Override
		public int get(int index) {
			if (index == 0) {
				return BeaconOfUndyingBlockEntity.this.charge;
			}
			return 0;
		}

		@Override
		public void set(int index, int value) {
			if (index == 0) {
				BeaconOfUndyingBlockEntity.this.charge = value;
			}
		}

		@Override
		public int size() {
			return 1;
		}
	}
}
