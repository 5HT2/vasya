package org.dominikaaaa.vasya.mixins;

import net.minecraft.client.gui.screen.TitleScreen;
import org.dominikaaaa.vasya.features.TestFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
// Mixins HAVE to be written in java due to constraints in the mixins system.
public class VasyaMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        TestFeature.INSTANCE.toggle(false);
        TestFeature.INSTANCE.toggle(true);
        System.out.println("Init Vasya!");
    }
}
