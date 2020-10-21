/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.nullable

/**
 * @author Yuriy Stul
 */

fun foo(s: String?): List<String> {
    return s!!.split(' ')   // not-null assertion
}

fun bar(s: String?): List<String> {
    return s?.split(' ') ?: listOf()
}

fun main() {

    try {
        println("foo(null):")
        println("foo(null): ${foo(null)}")
    } catch (error: Exception) {
        println("error: ${error.message}")
    }
    println("bar(null): ${bar(null)}")
    println("foo(\"1 2 3 \"): ${foo("1 2 3 ")}")
}
