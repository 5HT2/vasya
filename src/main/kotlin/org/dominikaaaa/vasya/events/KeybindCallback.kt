package org.dominikaaaa.vasya.events

import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.client.MinecraftClient

interface KeybindCallback {
    fun press(key: Int)
    companion object {
        @JvmField
        val EVENT: Event<KeybindCallback> = EventFactory.createArrayBacked(
            KeybindCallback::class.java
        ) {
            object : KeybindCallback {
                override fun press(key: Int) {
                }
            }
        }
    }
}