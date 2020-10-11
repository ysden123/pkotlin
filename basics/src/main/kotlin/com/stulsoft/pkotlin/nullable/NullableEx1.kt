/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.nullable

/**
 * @author Yuriy Stul
 */

fun foo(s: String?): List<String> {
    return s!!.split(' ')
}

fun bar(s: String?): List<String> {
    return s?.split(' ') ?: listOf()
}

fun main() {

    try {
        println(foo(null))
    } catch (error: Exception) {
        println("error: ${error.message}")
    }
    println(bar(null))
    println(foo("1 2 3 "))
}