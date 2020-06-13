package org.dominikaaaa.vasya

import net.fabricmc.fabric.api.event.client.ClientTickCallback
import net.minecraft.client.MinecraftClient
import org.dominikaaaa.vasya.events.KeybindCallback
import org.dominikaaaa.vasya.features.TestFeature
import org.dominikaaaa.vasya.features.TestFeatureOther

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 10/06/20 at 11:26
 */
@Suppress("unused")
fun init() {

    /* initialize the Manager */
    Manager

    /**
     * @see Feature.onUpdate
     */
    ClientTickCallback.EVENT.register(ClientTickCallback {
        for (Feature in Manager.features) {
            Feature.registerUpdate()
        }
    })

    KeybindCallback.EVENT.register(object: KeybindCallback {
        override fun press(key: Int, state: Int) {
            if (MinecraftClient.getInstance().player == null) return
            if (key == 79 && state == 1) TestFeature.toggle() // TODO: bind manager
            if (key == 80 && state == 1) TestFeatureOther.toggle()
        }
    })
}

