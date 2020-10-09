/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz

/**
 * @author Yuriy Stul
 */
data class DataEx2(val name: String, val age: Int){
    private val firstProperty = "First property: $name".also(::println)
    init {
        println("First initialization block: $name")
    }

    override fun toString(): String {
        return "DataEx2(name='$name', age=$age, firstProperty='$firstProperty')"
    }

}

fun main() {
    val dataEx2 = DataEx2("test", 22)
    println("dataEx2: $dataEx2")
}