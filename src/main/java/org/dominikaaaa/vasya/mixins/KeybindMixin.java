package org.dominikaaaa.vasya.mixins;

import net.minecraft.client.Keyboard;
import org.dominikaaaa.vasya.events.KeybindCallback;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeybindMixin {
    @Inject(at = @At("HEAD"), method = "onKey")
    private void onKey(long window, int key, int scancode, int i, int j, CallbackInfo ci) {
        KeybindCallback.EVENT.invoker().press(key);
    }
}
