/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.log.analyzer

import org.slf4j.LoggerFactory
import java.io.File
import java.text.NumberFormat

/**
 * @author Yuriy Stul
 */
object EtlExecutions {
    val logger = LoggerFactory.getLogger("")

    private fun jobs(filePath: String) {
        val insertText = "In ETLJobRegisterVerticle.handler: finished insert in"
        val updateText = "In ETLJobRegisterVerticle.handler: finished update in"

        try {
            var insertMin = Long.MAX_VALUE
            var insertMax = 0L
            var insertTotal = 0L
            var insertCount = 0L
            var updateMin = Long.MAX_VALUE
            var updateMax = 0L
            var updateTotal = 0L
            var updateCount = 0L
            File(filePath).useLines {
                it.filter { s ->
                    s.contains(insertText) || s.contains(updateText)
                }
                        .forEach {
                            run {
                                if (it.contains(insertText)) {
                                    val start = it.indexOf(insertText) + insertText.length + 1
                                    val end = it.indexOf(' ', start)
                                    val duration = it.substring(start, end).toLong()
                                    ++insertCount
                                    if (duration > insertMax) insertMax = duration
                                    if (duration < insertMin) insertMin = duration
                                    insertTotal += duration
                                } else {
                                    val start = it.indexOf(updateText) + updateText.length + 1
                                    val end = it.indexOf(' ', start)
                                    val duration = it.substring(start, end).toLong()
                                    ++updateCount
                                    if (duration > updateMax) updateMax = duration
                                    if (duration < updateMin) updateMin = duration
                                    updateTotal += duration
                                }
                            }
                        }
                val nf = NumberFormat.getInstance()
                if (insertCount > 0) {
                    logger.info("Insert Job operation: operations=${nf.format(insertCount)} min=${nf.format(insertMin)}ms, max=${nf.format(insertMax)}ms, average=${nf.format(insertTotal / insertCount)}ms")
                }
                if (updateCount > 0) {
                    logger.info("Update Job operation: operations=${nf.format(updateCount)} min=${nf.format(updateMin)}ms, max=${nf.format(updateMax)}ms, average=${nf.format(updateTotal / updateCount)}ms")
                }
            }
        } catch (ex: Exception) {
            logger.error(ex.message, ex)
        }
    }

    private fun steps(filePath: String) {
        val text = "In kafkaMessageHandlerAsync: finished in"
        fun extractNumber(line: String): Int {
            val start = line.indexOf(text) + text.length + 1
            val end = line.indexOf(' ', start)
            val numberAsText = line.subSequence(start, end).toString()
            return numberAsText.toInt()
        }

        var amount = 0
        var total = 0
        var min = Int.MAX_VALUE
        var max = 0

        try {
            File(filePath).useLines {
                it.filter { line -> line.contains("In kafkaMessageHandlerAsync: finished") }
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
                    val average = total.toFloat() / amount.toFloat()
                    logger.info("Step registration operations=${nf.format(amount)}, min=${nf.format(min)}ms, max=${nf.format(max)}ms, average=${nf.format(average)}ms")
                } else
                    logger.info("Step registration operations=${nf.format(amount)}")
            }
        } catch (ex: Exception) {
            logger.error(ex.message, ex)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val path: String? = if (args.size == 1) {
            args[0]
        } else {
            println("Enter file path to log file:")
            readLine()
        }
        if (path != null) {
            println("Analyzing $path")
            jobs(path)
            steps(path)
        }
    }
}
