package org.dominikaaaa.vasya.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.dominikaaaa.vasya.utils.VasyaCommandSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientCommandSource.class)
public abstract class ClientCommandSourceMixin implements VasyaCommandSource {
    @Shadow
    @Final
    private MinecraftClient client;

    @Override
    public void sendFeedback(Text message) {
        client.player.addChatMessage(message, false);
    }

    @Override
    public void sendFeedback(Text message, boolean actionBar) {
        client.player.addChatMessage(message, actionBar);
    }

    @Override
    public void sendError(Text text) {
        client.player.addChatMessage(new LiteralText("").append(text).formatted(Formatting.RED), false);
    }
}