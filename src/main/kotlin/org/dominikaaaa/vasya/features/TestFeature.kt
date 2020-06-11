package org.dominikaaaa.vasya.features

import net.minecraft.client.MinecraftClient
import org.dominikaaaa.vasya.Feature

object TestFeature : Feature("TestFeature", null, Category.PLAYER) {
    override fun onEnable() {
        MinecraftClient.getInstance().player?.sendChatMessage("enabled $name")
    }

    override fun onDisable() {
        MinecraftClient.getInstance().player?.sendChatMessage("disabled $name")
    }

}