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

    private fun etlJobs(filePath: String) {
        val startText = "In kafkaMessageHandler: working on message: {"
        val endInsertText = "In ExecutionMonitorFindEtlJobStep: after record has been inserted {"
        val endUpdateText = "In ExecutionMonitorUpdateEtlJobStep: after updating "

        fun extractTime(line: String): Long {
            return Utils.logTime(line.substring(1, 28))
        }

        try {
            var startTime = 0L
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
                    s.contains(startText)
                            || s.contains(endInsertText)
                            || s.contains(endUpdateText)
                }
                        .forEach {
                            run {
                                if (it.contains(startText))
                                    startTime = extractTime(it)
                                else if (it.contains(endInsertText)) {
                                    val duration = extractTime(it) - startTime
                                    ++insertCount
                                    if (duration > insertMax) insertMax = duration
                                    if (duration < insertMin) insertMin = duration
                                    insertTotal += duration
                                } else {
                                    val duration = extractTime(it) - startTime
                                    ++updateCount
                                    if (duration > updateMax) updateMax = duration
                                    if (duration < updateMin) updateMin = duration
                                    updateTotal += duration
                                }
                            }
                        }
                val nf = NumberFormat.getInstance()
                if (insertCount > 0) {
                    logger.info("Insert operation: operations=${nf.format(insertCount)} min=${nf.format(insertMin)}ms, max=${nf.format(insertMax)}ms, average=${nf.format(insertTotal / insertCount)}ms")
                }
                if (updateCount > 0) {
                    logger.info("Update operation: operations=${nf.format(updateCount)} min=${nf.format(updateMin)}ms, max=${nf.format(updateMax)}ms, average=${nf.format(updateTotal / updateCount)}ms")
                }
            }
        } catch (ex: Exception) {
            logger.error(ex.message, ex)
        }
    }

    private fun etlSteps(filePath: String) {
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
        etlJobs("c:/transmit/qa/console.txt")
        etlSteps("c:/transmit/qa/console.txt")
    }
}
