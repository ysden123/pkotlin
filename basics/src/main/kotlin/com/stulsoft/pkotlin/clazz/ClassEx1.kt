/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz

/**
 * @author Yuriy Stul
 */
class ClassEx1(val name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initialization block: $name")
    }

    val secondaryProperty = "Secondary property: ${name.length}".also(::println)

    init {
        println("Second initialization block: ${name.length}")
    }
}

fun main() {
    val cex1 = ClassEx1("test 1")
    println("Name: ${cex1.name}")
    println("cex1: $cex1")
}