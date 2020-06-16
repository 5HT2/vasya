package org.dominikaaaa.vasya

import org.dominikaaaa.vasya.commands.TestCommand
import org.dominikaaaa.vasya.features.TestFeature
import org.dominikaaaa.vasya.features.TestFeatureOther

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 12/06/20 at 12:56
 *
 * Used to manage all the features and commands from convenient lists
 */
object Manager {
    val features = listOf(TestFeature, TestFeatureOther)
    val commands = listOf(TestCommand)

    init {
        println("[${Feature.vasya}] Init Features!")
        println(features)
    }
}