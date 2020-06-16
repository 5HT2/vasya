package org.dominikaaaa.vasya.mixins;

import net.minecraft.client.network.ClientPlayerEntity;
import org.dominikaaaa.vasya.events.ChatMessageCallback;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "sendChatMessage", cancellable = true)
    private void onChatMessage(String message, CallbackInfo ci) {
        boolean callback = ChatMessageCallback.EVENT.invoker().send(message);
        if (callback) ci.cancel();
    }
}
