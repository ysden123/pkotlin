/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz

/**
 * @author Yuriy Stul
 */
data class DataEx1(val name: String, val age: Int)

fun main() {
    val dataEx1 = DataEx1("test", 22)
    println("dataEx1: $dataEx1")
}