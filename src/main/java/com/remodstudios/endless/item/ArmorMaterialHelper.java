package com.remodstudios.endless.item;

import java.util.function.ToIntFunction;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Lazy;

public enum ArmorMaterialHelper implements ArmorMaterial {
	;

	private final ToIntFunction<EquipmentSlot> durabilityFunction;
	private final ToIntFunction<EquipmentSlot> protectionFunction;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final String name;
	private final float toughness;
	private final float knockbackResistance;
	private final Lazy<Ingredient> repairIngredientSupplier;

	ArmorMaterialHelper(ToIntFunction<EquipmentSlot> durabilityFunction, ToIntFunction<EquipmentSlot> protectionFunction, int enchantability, SoundEvent equipSound, String name, float toughness, float knockbackResistance, Lazy<Ingredient> repairIngredientSupplier) {
		this.durabilityFunction = durabilityFunction;
		this.protectionFunction = protectionFunction;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.name = name;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredientSupplier = repairIngredientSupplier;
	}

	@Override
	public int getDurability(EquipmentSlot slot) {
		return this.durabilityFunction.applyAsInt(slot);
	}


	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return this.protectionFunction.applyAsInt(slot);
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredientSupplier.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
