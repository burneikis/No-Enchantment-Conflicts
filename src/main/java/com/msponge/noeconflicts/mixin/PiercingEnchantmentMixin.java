package com.msponge.noeconflicts.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.enchantment.PiercingEnchantment;
import net.minecraft.enchantment.MultishotEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

import com.msponge.noeconflicts.config.Config;

@Mixin(PiercingEnchantment.class)
public class PiercingEnchantmentMixin extends Enchantment{
    public PiercingEnchantmentMixin(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.BOW, slotTypes);
	}

    @Override
    public boolean canAccept(Enchantment other) {
        if (!Config.INSTANCE.PiercingEnchantment) {
            if (other instanceof MultishotEnchantment) {
                return false;
            }
        }
        return super.canAccept(other);
    }
}
