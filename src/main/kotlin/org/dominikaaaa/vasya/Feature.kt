package org.dominikaaaa.vasya

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 10/06/20 at 11:26
 */
open class Feature(val name: String?, val description: String?, val category: Category?, var enabled: Boolean = false) {

    open fun onEnable() {}

    open fun onDisable() {}

    open fun onToggle() {}

    open fun onUpdate() {}

    fun toggle(state: Boolean) {
        if (state && !enabled) {
            onToggle()
            onEnable()
        } else if (!state && enabled) {
            onToggle()
            onDisable()
        }
        enabled = state
    }

    fun toggle() {
        toggle(!enabled)
    }

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