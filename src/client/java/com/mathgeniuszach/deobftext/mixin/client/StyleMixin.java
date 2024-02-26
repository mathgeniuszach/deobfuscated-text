package com.mathgeniuszach.deobftext.mixin.client;

import net.minecraft.text.Style;
import net.minecraft.util.math.random.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Style.class)
public class StyleMixin {
    Random rng = Random.create();

    @Inject(at = @At("RETURN"), method = "isObfuscated", cancellable = true)
    public void isObfuscated(CallbackInfoReturnable<Boolean> info) {
        if (info.getReturnValue() && rng.nextFloat() < 0.5f) {
            info.setReturnValue(false);
        }
    }
}