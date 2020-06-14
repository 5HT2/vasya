package org.dominikaaaa.vasya

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 12/06/20 at 20:09
 */
object Binds {
    val binds: HashMap<Int, Feature> = hashMapOf()

    init {
        for (Feature in Manager.features) {
            binds[Feature.bind] = Feature
        }
        println("[${Feature.vasya}] Init Binds!")
        println(binds)
    }
}