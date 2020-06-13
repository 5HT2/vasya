package org.dominikaaaa.vasya.features

import org.dominikaaaa.vasya.Feature

object TestFeature : Feature("TestFeature", null, Category.PLAYER, 79) {
    override fun onEnable() {
        mc.player?.sendChatMessage("enabled $name")
    }

    override fun onDisable() {
        mc.player?.sendChatMessage("disabled $name")
    }

    override fun onUpdate() {
        TestFeatureOther.mc.player?.sendChatMessage("update $name")
    }
}