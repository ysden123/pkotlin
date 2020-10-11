/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz.delegation

/*
Delegation with multiple interfaces.
 */

interface I1 {
    fun i1Method(n: Int)
}

interface I2 {
    /**
     * Some test fun
     * @param s some text
     */
    fun i2Method(s: String)
}

class I1Impl : I1 {
    override fun i1Method(n: Int) {
        println("in i1Method. n = $n")
    }
}

class I2Impl : I2 {
    /**
     * Some test fun
     * @param s some text
     */
    override fun i2Method(s: String) {
        println("in i2Method. s: $s")
    }
}

class DerivedEx3(i1: I1, i2: I2) : I1 by i1, I2 by i2 {
    fun test() {
        println("In test")
        i1Method(543)
        i2Method("second test")
    }
}

fun main() {
    val i1: I1 = I1Impl()
    val i2: I2 = I2Impl()
    val d = DerivedEx3(i1, i2)

    d.i1Method(123)
    d.i2Method("first test")
    d.test()
}