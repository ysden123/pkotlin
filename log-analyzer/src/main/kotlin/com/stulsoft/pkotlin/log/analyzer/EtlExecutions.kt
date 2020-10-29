/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.log.analyzer

import org.apache.commons.lang3.time.DurationFormatUtils
import org.slf4j.LoggerFactory
import java.io.File
import java.text.NumberFormat
import kotlin.system.exitProcess

/**
 * @author Yuriy Stul
 */
object EtlExecutions {
    private val logger = LoggerFactory.getLogger("")

    private fun jobs(files: Array<String>) {
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
            fun calculateStatistics(filePath: String) {
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
                }
            }

            files.forEach { calculateStatistics(it) }

            val nf = NumberFormat.getInstance()
            if (insertCount > 0) {
                val format = "HH:mm:ss.SSS"
                val minText = trimLeadingZerosTime(DurationFormatUtils.formatDuration(insertMin, format))
                val maxText = trimLeadingZerosTime(DurationFormatUtils.formatDuration(insertMax, format))
                val averageText = trimLeadingZerosTime(DurationFormatUtils
                        .formatDuration(insertTotal / insertCount, format))
                val outputText = "Insert Job operation: operations=${nf.format(insertCount)} min=$minText, max=$maxText, average=$averageText"
                println(outputText)
                logger.info(outputText)
            }
            if (updateCount > 0) {
                val format = "HH:mm:ss.SSS"
                val minText = trimLeadingZerosTime(DurationFormatUtils.formatDuration(updateMin, format))
                val maxText = trimLeadingZerosTime(DurationFormatUtils.formatDuration(updateMax, format))
                val averageText = trimLeadingZerosTime(DurationFormatUtils
                        .formatDuration(updateTotal / updateCount, format))
                val outputText = "Update Job operation: operations=${nf.format(updateCount)} min=$minText, max=$maxText, average=$averageText"
                println(outputText)
                logger.info(outputText)
            }
        } catch (ex: Exception) {
            logger.error(ex.message, ex)
        }
    }

    private fun steps(files: Array<String>) {
        val text = "In kafkaMessageHandlerAsync: finished in"
        fun extractNumber(line: String): Long {
            val start = line.indexOf(text) + text.length + 1
            val end = line.indexOf(' ', start)
            val numberAsText = line.subSequence(start, end).toString()
            return numberAsText.toLong()
        }

        var amount = 0L
        var total = 0L
        var min = Long.MAX_VALUE
        var max = 0L

        try {
            fun calculateStatistics(filePath: String) {
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
                }
            }

            files.forEach { calculateStatistics(it) }
            val nf = NumberFormat.getInstance()
            if (amount > 0) {
                val format = "HH:mm:ss.SSS"
                val minText = trimLeadingZerosTime(DurationFormatUtils.formatDuration(min, format))
                val maxText = trimLeadingZerosTime(DurationFormatUtils.formatDuration(max, format))
                val averageText = trimLeadingZerosTime(DurationFormatUtils
                        .formatDuration(total / amount, format))
                val outputText = "Step registration operations=${nf.format(amount)}, min=$minText, max=$maxText, average=$averageText"
                println(outputText)
                logger.info(outputText)
            } else {
                val outputText = "Step registration operations=${nf.format(amount)}"
                println(outputText)
                logger.info(outputText)
            }
        } catch (ex: Exception) {
            println(ex.message)
            logger.error(ex.message, ex)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            println("Usage: java -jar <JAR file> file1 [file2 [file3]]")
            exitProcess(1)
        }
        println("Analyzing files:")
        args.forEach { println(it) }

        jobs(args)
        steps(args)
    }
}
