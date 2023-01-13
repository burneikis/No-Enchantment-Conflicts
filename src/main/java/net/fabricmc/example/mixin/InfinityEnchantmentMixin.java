package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentMixin extends Enchantment{
    public InfinityEnchantmentMixin(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.BOW, slotTypes);
	}

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
