package org.dominikaaaa.vasya

import org.dominikaaaa.vasya.features.TestFeature
import org.dominikaaaa.vasya.features.TestFeatureOther

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 12/06/20 at 12:56
 *
 * Used to manage all the features from a convenient list
 */
object Manager {
    val features: MutableList<Feature> // DON'T combine declaration and assignment

    init {
        features = mutableListOf()
        TestFeature
        TestFeatureOther
        println("Init Features!")
        println(features)
    }
}