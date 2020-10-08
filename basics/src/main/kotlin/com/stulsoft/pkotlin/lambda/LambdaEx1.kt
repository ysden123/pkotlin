/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.lambda

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */

val logger: Logger = LoggerFactory.getLogger("")

fun main() {
    logger.info("==>main")
    logger.info("test1: {}", test1 { s -> "$s processed 1" })
    logger.info("test1: {}", test1 { "$it processed 2" })
    logger.info("test2: {}", test2 { "$it processed" })
}

/**
 * Function with body block. Must use return operator
 */
fun test1(f: (String) -> String): String {
    return f("test1")
}

/**
 * Function without body block. Works without return operator
 */
fun test2(f: (String) -> String) = f("test2")

/**
 * Function without body block. Works without return operator
 */
fun test3(f: (String) -> String) = run {
    logger.info("In test 3")
    f("test2")
}
