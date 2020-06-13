package org.dominikaaaa.vasya

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 12/06/20 at 20:09
 */
object Binds {
    val binds: HashMap<Feature, Int> = hashMapOf()

    init {
        for (Feature in Manager.features) {
            binds[Feature] = Feature.bind
        }
        println("Init Binds!")
        println(binds)
    }
}