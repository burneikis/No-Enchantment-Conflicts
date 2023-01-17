package com.msponge.noeconflicts.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

import com.msponge.noeconflicts.config.Config;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentMixin extends Enchantment{
    public InfinityEnchantmentMixin(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.BOW, slotTypes);
	}

    @Override
    public boolean canAccept(Enchantment other) {
        if (!Config.INSTANCE.InfinityEnchantment) {
            if (other instanceof MendingEnchantment) {
                return false;
            }
        }
        return super.canAccept(other);
    }
}
