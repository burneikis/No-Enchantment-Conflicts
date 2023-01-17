package nerdhub.infinityfix.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(InfinityEnchantment.class)
public class MixinInfinityEnchantment extends Enchantment {

    protected MixinInfinityEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot[] applicableSlots) {
        super(weight, target, applicableSlots);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack) || stack.getItem() instanceof RangedWeaponItem;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
