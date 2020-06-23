package org.dominikaaaa.vasya.mixins;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import org.dominikaaaa.vasya.Manager;
import org.dominikaaaa.vasya.events.ChatMessageCallback;
import org.dominikaaaa.vasya.utils.VasyaCommandSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Shadow
    @Final
    public ClientPlayNetworkHandler networkHandler;

    @Shadow
    @Final
    protected MinecraftClient client;

    @Inject(at = @At("HEAD"), method = "sendChatMessage", cancellable = true)
    private void onChatMessage(String message, CallbackInfo ci) {
        boolean callback = ChatMessageCallback.EVENT.invoker().send(message);
        if (callback) {
            ci.cancel();
            return;
        }

        try {
            Manager.dispatcher.execute(message.substring(1), (VasyaCommandSource) new ClientCommandSource(networkHandler, client));
            ci.cancel();
        } catch (CommandSyntaxException ignored) {
        }

    }
}
