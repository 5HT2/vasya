package org.dominikaaaa.vasya.features

import org.dominikaaaa.vasya.Feature

object TestFeatureOther : Feature("TestFeature2", null, Category.PLAYER, 80) {
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