package org.dominikaaaa.vasya.mixins;

import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.dominikaaaa.vasya.events.KeybindCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeybindMixin {
    /**
     * @see GLFWKeyCallbackI
     * Will be called when a key is pressed, repeated or released.
     *
     * @param window   the window that received the event
     * @param key      the keyboard key that was pressed or released
     * @param scancode the system-specific scancode of the key
     * @param action   the key action. One of:<br><table><tr><td>{@link GLFW#GLFW_PRESS PRESS}</td><td>{@link GLFW#GLFW_RELEASE RELEASE}</td><td>{@link GLFW#GLFW_REPEAT REPEAT}</td></tr></table>
     * @param mods     bitfield describing which modifiers keys were held down
     */
    @Inject(at = @At("HEAD"), method = "onKey")
    private void onKey(long window, int key, int scancode, int action, int mods, CallbackInfo ci) {
        if (MinecraftClient.getInstance().currentScreen == null) {
            KeybindCallback.EVENT.invoker().press(key, action);
        }
    }
}
