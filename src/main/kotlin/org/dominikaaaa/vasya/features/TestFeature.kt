package org.dominikaaaa.vasya.features

import org.dominikaaaa.vasya.Feature

object TestFeature : Feature("TestFeature", null, Category.PLAYER, 79) {
    override fun onEnable() {
        sendMessage("enabled $name")
    }

    override fun onDisable() {
        sendMessage("disabled $name")
    }

    override fun onUpdate() {
        sendMessage("update $name")
    }
}