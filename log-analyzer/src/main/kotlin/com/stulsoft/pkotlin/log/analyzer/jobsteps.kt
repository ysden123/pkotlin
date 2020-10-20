/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.log.analyzer

import org.slf4j.LoggerFactory
import java.io.BufferedReader
import java.io.FileReader
import java.text.NumberFormat

/**
 * @author Yuriy Stul
 */

fun main() {
    val logger = LoggerFactory.getLogger("")
    val text = "In kafkaMessageHandlerAsync: finished in"
    fun extractNumber(line: String): Int {
        val start = line.indexOf(text) + text.length + 1
        val end = line.indexOf(' ', start)
        val numberAsText = line.subSequence(start, end).toString()
        return numberAsText.toInt()
    }

    val reader = BufferedReader(FileReader("c:/transmit/qa/console.txt"))
    var amount = 0
    var total = 0
    var min = Int.MAX_VALUE
    var max = 0
    reader
            .lineSequence()
            .filter { line -> line.contains("In kafkaMessageHandlerAsync: finished") }
            .map { line -> extractNumber(line) }
            .forEach { n ->
                run {
                    ++amount
                    total += n
                    if (n < min) min = n
                    if (n > max) max = n
                }
            }

    val nf = NumberFormat.getInstance()
    if (amount > 0) {
        var average = total.toFloat() / amount.toFloat()
        logger.info("amount=${nf.format(amount)}, total=${nf.format(total)}, min=${nf.format(min)}, max=${nf.format(max)}, average=$average")
    } else
        logger.info("amount=${nf.format(amount)}, total=${nf.format(total)}")
}
