package org.dominikaaaa.vasya.features

import org.dominikaaaa.vasya.Feature

object TestFeatureOther : Feature("TestFeature2", null, Category.PLAYER) {
    override fun onEnable() {
        mc.player?.sendChatMessage("enabled ${TestFeature.name}")
    }

    override fun onDisable() {
        mc.player?.sendChatMessage("disabled ${TestFeature.name}")
    }

}