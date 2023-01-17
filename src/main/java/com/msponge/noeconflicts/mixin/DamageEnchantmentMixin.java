package com.msponge.noeconflicts.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

import com.msponge.noeconflicts.config.Config;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin extends Enchantment{
    public DamageEnchantmentMixin(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.WEAPON, slotTypes);
	}

    @Override
    public boolean canAccept(Enchantment other) {
        if (!Config.INSTANCE.DamageEnchantments) {
            if (other instanceof DamageEnchantment) {
                return false;
            }
        }
        return super.canAccept(other);
    }
}
