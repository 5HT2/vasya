package org.dominikaaaa.vasya.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import org.dominikaaaa.vasya.Command
import org.dominikaaaa.vasya.Feature

object TestCommand : Command("Test", null, 1, 1) {
    override fun dispatch(dispatcher: CommandDispatcher<ServerCommandSource>) {
        dispatcher.register(
            CommandManager.literal("isweartogodifthisworks")
                .then(CommandManager.literal("bruh").executes { context: CommandContext<ServerCommandSource?>? ->
                    Feature.sendMessage("fuck you")
                    1
                })
        )
    }
}