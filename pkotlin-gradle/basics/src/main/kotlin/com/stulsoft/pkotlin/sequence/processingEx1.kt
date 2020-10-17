/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.sequence

import org.slf4j.LoggerFactory

/**
 * See <a href="https://kotlinlang.org/docs/reference/sequences.html#sequence-operations">Sequences</a>
 * @author Yuriy Stul
 */

private val logger = LoggerFactory.getLogger("")

fun main() {
    fun test1() {
        logger.info("==>pEx1test1")
        val words = "The quick brown fox jumps over the lazy dog".split(" ")
// convert the List to a Sequence
        val wordsSequence = words.asSequence()

        val lengthsSequence = wordsSequence.filter { logger.info("filter: $it"); it.length > 3 }
                .map { logger.info("length: ${it.length}"); it.length }
                .take(4)

        logger.info("Lengths of first 4 words longer than 3 chars")
// terminal operation: obtaining the result as a List
        logger.info("${lengthsSequence.toList()}")
    }

    logger.info("Start")
    test1()
}

