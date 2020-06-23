package org.dominikaaaa.vasya

import com.mojang.brigadier.CommandDispatcher
import org.dominikaaaa.vasya.commands.TestCommand
import org.dominikaaaa.vasya.features.TestFeature
import org.dominikaaaa.vasya.features.TestFeatureOther
import org.dominikaaaa.vasya.utils.VasyaCommandSource

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 12/06/20 at 12:56
 *
 * Used to manage all the features and commands from convenient lists
 */
object Manager {
    val features = listOf(TestFeature, TestFeatureOther)
    val commands = listOf(TestCommand)

    @JvmField
    val dispatcher = CommandDispatcher<VasyaCommandSource>()

    init {
        println("[${Feature.vasya}] Init Features!")
        println(features)
    }
}