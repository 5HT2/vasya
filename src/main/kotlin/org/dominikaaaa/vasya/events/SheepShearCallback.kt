package org.dominikaaaa.vasya.events

import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.entity.passive.SheepEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.ActionResult

interface SheepShearCallback {
    fun interact(player: PlayerEntity, sheep: SheepEntity): ActionResult
    companion object {
        @JvmField
        val EVENT: Event<SheepShearCallback> = EventFactory.createArrayBacked(
            SheepShearCallback::class.java
        ) {
            object : SheepShearCallback {
                override fun interact(player: PlayerEntity, sheep: SheepEntity): ActionResult {
                    it.forEach { listener -> if (listener.interact(player, sheep) != ActionResult.PASS) return@forEach }
                    return ActionResult.PASS
                }
            }
        }
    }
}