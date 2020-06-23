package org.dominikaaaa.vasya.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.context.CommandContext
import org.dominikaaaa.vasya.Command
import org.dominikaaaa.vasya.Feature
import org.dominikaaaa.vasya.utils.VasyaCommandSource

object TestCommand : Command("Test", null, 1, 1) {
    override fun dispatch(dispatcher: CommandDispatcher<VasyaCommandSource>) {
        dispatcher.register(
            LiteralArgumentBuilder.literal<VasyaCommandSource>("test")
                .then(
                    LiteralArgumentBuilder.literal<VasyaCommandSource>("epic")
                        .executes { context: CommandContext<VasyaCommandSource> ->
                            Feature.sendMessage("congrats dumb head")
                            0
                        })
        )
    }
}