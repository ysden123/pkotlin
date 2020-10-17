/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.collection

/**
 * @author Yuriy Stul
 */

fun main() {
    fun sliceEx1(){
        println("==>sliceEx1")
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.slice(1..3))
        println(numbers.slice(0..4 step 2))
        println(numbers.slice(setOf(3, 5, 0)))
    }

    sliceEx1()
}