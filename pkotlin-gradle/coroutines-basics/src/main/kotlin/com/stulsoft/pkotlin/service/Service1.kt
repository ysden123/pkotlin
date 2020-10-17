/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.service

import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * @author Yuriy Stul
 */
object Service1 {
    private val random = Random

    suspend fun foo(i: Int): String {
        delay(random.nextLong(123, 1000))
        return "foo: done for $i"
    }

    suspend fun bar(i: Int): String {
        delay(random.nextLong(123, 1000))
        return "bar: done for $i"
    }
}

suspend fun main() {
    test1()
}

suspend fun test1() {
    println("==>test1")
    for (i in 1..5) {
        println("for $i - ${Service1.foo(i)}")
        println("for $i - ${Service1.bar(i)}")
    }
}