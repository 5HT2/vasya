package org.dominikaaaa.vasya.features

import org.dominikaaaa.vasya.Feature

object TestFeature : Feature("TestFeature", null, Category.PLAYER) {
    override fun onEnable() {
        println("enabled $name")
    }

    override fun onDisable() {
        println("disabled $name")
    }

}