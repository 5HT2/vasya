package org.dominikaaaa.vasya

import net.fabricmc.fabric.api.event.client.ClientTickCallback
import net.minecraft.client.MinecraftClient
import org.dominikaaaa.vasya.events.ChatMessageCallback
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

/*    CommandRegistrationCallback.EVENT.register(object : CommandRegistrationCallback {
        override fun register(dispatcher: CommandDispatcher<ServerCommandSource>, dedicated: Boolean) {
            for (command in Manager.commands) {
                command.dispatch(dispatcher)
            }
        }
    })*/

    ChatMessageCallback.EVENT.register(object : ChatMessageCallback {
        override fun send(message: String): Boolean {
            if (message.startsWith(";")) {
                // TODO: Command system
                return true
            }
            return false
        }
    })

}

