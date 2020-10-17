/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz

data class MC1(private val name: String, private val age: Int)

data class MC2(private val country: String, private val size: Int)

fun main() {
    val mc1 = MC1("test 1", 123)
    val mc2 = MC2("country 1", 4)

    println("mc1: $mc1")
    println("mc2: $mc2")
}