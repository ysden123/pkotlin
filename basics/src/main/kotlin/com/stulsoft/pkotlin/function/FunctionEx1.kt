/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.function

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */
val logger: Logger = LoggerFactory.getLogger("")

fun main() {
    logger.info("===>main")
    test1()
    test2()
    test3()
}

/**
 * Usage the run operator
 */
fun test1() {
    logger.info("===>test1")
    val numbers = mutableListOf("one", "two", "three")
    val countEndsWithE = numbers.run {
        add("four")
        add("five")
        count { it.endsWith("e") }
    }
    println("There are $countEndsWithE elements that end with e.")
}

/**
 * Usage the with operator
 */
fun test2() {
    logger.info("===>test2")
    val numbers = listOf("one", "two", "three")
    with(numbers) {
        val firstItem = first()
        val lastItem = last()
        println("First item: $firstItem, last item: $lastItem")
    }
}

/**
 * Usage the with operator
 */
fun test3() {
    logger.info("===>test3")
    val numbers = listOf(1,2,3)
    with(numbers) {
        val sum = sum()
        val fold = fold(0) {acc, i -> acc + i * 2}
        println("sum = $sum, fold = $fold")
    }
}