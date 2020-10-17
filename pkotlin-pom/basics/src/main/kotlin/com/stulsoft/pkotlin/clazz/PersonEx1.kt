/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz

/**
 * @author Yuriy Stul
 */
class PersonEx1(private val name:String, private val age:Int) {
    constructor(name:String): this(name, 0)

    override fun toString(): String {
        return "PersonEx1(name='$name', age=$age)"
    }
}

fun main() {
    val p1 = PersonEx1("test 1", 123)
    val p2 = PersonEx1("tes r2")

    println("p1: $p1")
    println("p2: $p2")
}