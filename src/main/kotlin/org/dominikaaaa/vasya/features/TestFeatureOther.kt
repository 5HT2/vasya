package org.dominikaaaa.vasya.features

import org.dominikaaaa.vasya.Feature
import org.lwjgl.glfw.GLFW

object TestFeatureOther : Feature("TestFeature2", null, Category.PLAYER, GLFW.GLFW_KEY_P) {
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