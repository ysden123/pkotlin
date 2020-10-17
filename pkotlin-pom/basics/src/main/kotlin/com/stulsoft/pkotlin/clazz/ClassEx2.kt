/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz

/**
 * @author Yuriy Stul
 */
class ClassEx2 public constructor(val name:String){
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
    val cex2 = ClassEx2("test 1")
    println("Name: ${cex2.name}")
    println("cex1: $cex2")
}