/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz

/**
 * @author Yuriy Stul
 */
data class PersonEx2(val name:String, val age: Int ) {
    constructor(name:String): this(name, 0)
}

fun main() {
    val p1 = PersonEx2("test 1", 123)
    val p2 = PersonEx2("test 1")

    println("p1: $p1")
    println("p2: $p2")
}