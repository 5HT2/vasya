package org.dominikaaaa.vasya.events

import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory

interface ChatMessageCallback {
    fun send(message: String): Boolean

    companion object {
        @JvmField
        val EVENT: Event<ChatMessageCallback> = EventFactory.createArrayBacked(
            ChatMessageCallback::class.java
        ) {
            object : ChatMessageCallback {
                override fun send(message: String): Boolean {
                    return false
                }
            }
        }
    }
}