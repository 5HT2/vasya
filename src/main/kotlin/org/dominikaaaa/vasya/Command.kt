package org.dominikaaaa.vasya

import com.mojang.brigadier.CommandDispatcher
import org.dominikaaaa.vasya.exceptions.CommandArgSizeException
import org.dominikaaaa.vasya.utils.CommandSource

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 13/06/20 at 14:12
 */
open class Command(
    val name: String,
    val description: String?,
    val minArgs: Int,
    val maxArgs: Int
) {
    open fun call(args: ArrayList<String>) {
        if (args.size > maxArgs || args.size < minArgs) {
            throw CommandArgSizeException("Wrong number of arguments! Min: $minArgs, Max: $maxArgs")
            return
        }
    }

    open fun dispatch(dispatcher: CommandDispatcher<CommandSource>) {}
}