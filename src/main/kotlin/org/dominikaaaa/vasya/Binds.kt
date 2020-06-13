package org.dominikaaaa.vasya

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 12/06/20 at 20:09
 */
object Binds {
    val binds: HashMap<Feature, Int> // DON'T combine declaration and assignment

    init {
        binds = hashMapOf()
        for (Feature in Manager.features) {
            binds[Feature] = Feature.bind
        }
        println("Init Binds!")
        println(binds)
    }
}