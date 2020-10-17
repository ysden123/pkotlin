/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.sequence

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */

private val logger: Logger = LoggerFactory.getLogger("")

fun main() {
    // From elements
    val seqFromElements: Sequence<Int> = sequenceOf(1, 2, 3, 4, 5)
    logger.info("seqFromElements: ${seqFromElements.toList()}")

    // From iterable
    val numbers = listOf(1, 2, 3, 4, 5)
    val seqFromIterable: Sequence<Int> = numbers.asSequence()
    logger.info("seqFromIterable: ${seqFromIterable.toList()}")

    // From function
    val oddNumbers = generateSequence(1) { it + 2 } // it is previous value
    logger.info("oddNumbers: ${oddNumbers.take(8).toList()}")

    // From function, finite sequence
    val oddNumbersLessThan10 = generateSequence(1) { if (it + 2 < 10) it + 2 else null }
    logger.info("oddNumbersLessThan10: ${oddNumbersLessThan10.toList()}")

    // From chunks
    val oddNumbersFromChunks = sequence {
        yield(1)
        yieldAll(listOf(3,5))
        yieldAll(generateSequence(7) { it + 2 })
    }
    logger.info("oddNumbersFromChunks: ${oddNumbersFromChunks.take(8).toList()}")
}

