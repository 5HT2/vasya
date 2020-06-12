package org.dominikaaaa.vasya

import org.dominikaaaa.vasya.features.TestFeature
import org.dominikaaaa.vasya.features.TestFeatureOther


/**
 * @author dominikaaaa
 * Created by dominikaaaa on 12/06/20 at 12:56
 */
open class Manager {
    companion object {
        val features: MutableList<Feature> = mutableListOf()

        init {
            features.add(TestFeature)
            features.add(TestFeatureOther)
            println("Init Features!")
        }
    }
}