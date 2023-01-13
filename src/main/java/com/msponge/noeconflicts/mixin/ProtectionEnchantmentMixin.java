package com.msponge.noeconflicts.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

@Mixin(ProtectionEnchantment.class)
public class ProtectionEnchantmentMixin extends Enchantment{
    public ProtectionEnchantmentMixin(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.ARMOR, slotTypes);
	}

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
