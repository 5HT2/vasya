package org.dominikaaaa.vasya

import com.mojang.brigadier.CommandDispatcher
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback
import net.fabricmc.fabric.api.event.client.ClientTickCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.server.command.ServerCommandSource
import org.dominikaaaa.vasya.events.KeybindCallback
import org.lwjgl.glfw.GLFW

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 10/06/20 at 11:26
 */
@Suppress("unused")
fun init() {

    /* initialize the Manager and Binds */
    Manager; Binds

    /**
     * @see Feature.onUpdate
     */
    ClientTickCallback.EVENT.register(ClientTickCallback {
        for (feature in Manager.features) {
            feature.registerUpdate()
        }
    })

    KeybindCallback.EVENT.register(object : KeybindCallback {
        override fun press(key: Int, state: Int) {
            if (MinecraftClient.getInstance().player == null) return
            if (key == GLFW.GLFW_KEY_SEMICOLON) {
                // TODO: Command system
            }

            for (bind in Binds.binds) {
                if (bind.key == key && state == 1) {
                    bind.value.toggle()
                }
            }
        }
    })

    CommandRegistrationCallback.EVENT.register(object : CommandRegistrationCallback {
        override fun register(dispatcher: CommandDispatcher<ServerCommandSource>, dedicated: Boolean) {
            for (command in Manager.commands) {
                command.dispatch(dispatcher)
            }
        }
    })
}

