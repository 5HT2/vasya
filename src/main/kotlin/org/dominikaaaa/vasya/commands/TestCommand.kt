package org.dominikaaaa.vasya.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.context.CommandContext
import org.dominikaaaa.vasya.Command
import org.dominikaaaa.vasya.Feature
import org.dominikaaaa.vasya.utils.CommandSource

object TestCommand : Command("Test", null, 1, 1) {
    override fun dispatch(dispatcher: CommandDispatcher<CommandSource>) {
        dispatcher.register(
            LiteralArgumentBuilder.literal<CommandSource>("isweartogodifthisworks")
                .then(LiteralArgumentBuilder.literal<CommandSource>("bruh").executes { context: CommandContext<CommandSource> ->
                    Feature.sendMessage("fuck you")
                    0
                })
        )
    }
}