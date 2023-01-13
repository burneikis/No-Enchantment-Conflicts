package com.msponge.noeconflicts.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin extends Enchantment{
    public DamageEnchantmentMixin(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.WEAPON, slotTypes);
	}

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
