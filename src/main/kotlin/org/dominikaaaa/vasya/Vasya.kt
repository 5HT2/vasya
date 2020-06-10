package org.dominikaaaa.vasya

import net.fabricmc.fabric.api.event.client.ClientTickCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.passive.SheepEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.ActionResult
import org.dominikaaaa.vasya.events.KeybindCallback
import org.dominikaaaa.vasya.events.SheepShearCallback
import org.dominikaaaa.vasya.features.TestFeature
import org.dominikaaaa.vasya.features.TestFeature.registerUpdate

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 10/06/20 at 11:26
 */
@Suppress("unused")
fun init() {

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

    /**
     * @see Feature.onUpdate
     */
    ClientTickCallback.EVENT.register(ClientTickCallback { registerUpdate() })

    KeybindCallback.EVENT.register(object: KeybindCallback {
        override fun press(key: Int) {
            if (key == 79) TestFeature.toggle() // TODO: bind manager
            MinecraftClient.getInstance().player!!.sendChatMessage("$key was pressed")
        }
    })
}

