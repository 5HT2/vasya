package org.dominikaaaa.vasya.utils

import net.minecraft.server.command.CommandSource
import net.minecraft.text.Text

/**
 * Empty class for creating a command source
 * You can do more with this, but a blank slate like so is perfectly fine for basic commands
 */
interface VasyaCommandSource : CommandSource {
    fun sendFeedback(message: Text?)
    fun sendFeedback(message: Text?, actionBar: Boolean)
    fun sendError(text: Text?)
}
