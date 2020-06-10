package org.dominikaaaa.vasya

import net.minecraft.entity.ItemEntity
import net.minecraft.entity.passive.SheepEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.ActionResult
import org.dominikaaaa.vasya.events.SheepShearCallback


@Suppress("unused")
fun init() {
    println("Hello Fabric world!")

    SheepShearCallback.EVENT.register(object: SheepShearCallback {
        override fun interact(player: PlayerEntity, sheep: SheepEntity): ActionResult {
            sheep.isSheared = true

            // create diamond item entity at sheep position
            val stack = ItemStack(Items.DIAMOND)
            val itemEntity = ItemEntity(player.world, sheep.x, sheep.y, sheep.z, stack)
            player.world.spawnEntity(itemEntity)
            return ActionResult.FAIL
        }
    })
}

