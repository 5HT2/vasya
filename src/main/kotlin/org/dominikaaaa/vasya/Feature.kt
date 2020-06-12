package org.dominikaaaa.vasya

import net.minecraft.client.MinecraftClient

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 10/06/20 at 11:26
 */
open class Feature(val name: String, val description: String?, val category: Category, _enabled: Boolean = false) {

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

    val mc: MinecraftClient = MinecraftClient.getInstance()

    /**
     * Used to force initialization of all Features at runtime
     */
    fun init() {}

    open fun registerUpdate() {
        if (enabled) {
            onUpdate()
        }
    }

    enum class Category(s: String) {
        PLAYER("Player"),
        WORLD("World")
    }
}