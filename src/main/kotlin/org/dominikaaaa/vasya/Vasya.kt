package org.dominikaaaa.vasya

import net.fabricmc.fabric.api.event.client.ClientTickCallback
import net.minecraft.client.MinecraftClient
import org.dominikaaaa.vasya.events.KeybindCallback

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
        for (Feature in Manager.features) {
            Feature.registerUpdate()
        }
    })

    KeybindCallback.EVENT.register(object : KeybindCallback {
        override fun press(key: Int, state: Int) {
            if (MinecraftClient.getInstance().player == null) return
            for (Binds in Binds.binds) {
                if (Binds.value == key && state == 1) {
                    Binds.key.toggle()
                }
            }
        }
    })
}

