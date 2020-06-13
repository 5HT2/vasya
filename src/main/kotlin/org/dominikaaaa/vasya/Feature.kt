package org.dominikaaaa.vasya

import net.minecraft.client.MinecraftClient

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 10/06/20 at 11:26
 */
open class Feature(val name: String, val description: String?, val category: Category, val bind: Int, _enabled: Boolean = false) {

    init {
        Manager.features.add(this)
    }

    var enabled = _enabled
        set(value) {
            if (field == value) return // Early return if field doesn't actually change
            field = value
            if (value)
                onEnable()
            else
                onDisable()
            onToggle()
        }

    open fun onEnable() {}

    open fun onDisable() {}

    open fun onToggle() {}

    open fun onUpdate() {}

    fun toggle() {
        enabled = !enabled
    }

    fun registerUpdate() {
        if (enabled) {
            onUpdate()
        }
    }

    val mc: MinecraftClient = MinecraftClient.getInstance()

    enum class Category(s: String) {
        PLAYER("Player"),
        WORLD("World")
    }
}