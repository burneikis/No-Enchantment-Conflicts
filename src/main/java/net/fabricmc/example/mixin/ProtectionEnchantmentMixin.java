package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.enchantment.Enchantment;

@Mixin(ProtectionEnchantment.class)
public class ProtectionEnchantmentMixin {
    @Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
    public void canCombine(Enchantment other, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
