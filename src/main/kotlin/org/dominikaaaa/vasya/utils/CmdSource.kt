package org.dominikaaaa.vasya.utils

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.exceptions.CommandSyntaxException
import org.dominikaaaa.vasya.Feature
import java.util.*

/**
 * @author 086
 * Used with explicit permission
 * KAMI Blue discord:
 * https://discordapp.com/channels/573954110454366214/634010567107149824/722482525573742623
 */
fun main() {
    Scanner(System.`in`).use { s ->
        val dispatcher = CommandDispatcher<CmdSource>()
sss
        dispatcher.register(
            LiteralArgumentBuilder.literal<CmdSource>("hello")
                .then(LiteralArgumentBuilder.literal<CmdSource>("world")
                    .executes {
                        println("Hello world!")
                        0
                    })
        )

        while (true) {
            print("> ")
            val line = s.nextLine()

            try {
                val exit = dispatcher.execute(line, CmdSource())
                println("(executed with exit code $exit)")
            } catch (e: CommandSyntaxException) {
                println("You have a syntax error: ${e.message}")
            }
        }
    }
}

class CmdSource