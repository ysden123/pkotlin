/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.log.analyzer

import org.slf4j.LoggerFactory
import java.io.File
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
            val insertStatistics = Statistics("Insert Job operation")
            val updateStatistics = Statistics("Update Job operation")
            fun calculateStatistics(filePath: String) {
                File(filePath).useLines { it ->
                    it.filter { s ->
                        s.contains(insertText) || s.contains(updateText)
                    }
                            .forEach {
                                if (it.contains(insertText)) {
                                    val start = it.indexOf(insertText) + insertText.length + 1
                                    val end = it.indexOf(' ', start)
                                    val duration = it.substring(start, end).toLong()
                                    insertStatistics.addTest(duration)
                                } else {
                                    val start = it.indexOf(updateText) + updateText.length + 1
                                    val end = it.indexOf(' ', start)
                                    val duration = it.substring(start, end).toLong()
                                    updateStatistics.addTest(duration)
                                }
                            }
                }
            }

            files.forEach { calculateStatistics(it) }

            println(insertStatistics.resultAsDuration())
            logger.info(insertStatistics.resultAsDuration())

            println(updateStatistics.resultAsDuration())
            logger.info(updateStatistics.resultAsDuration())
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

        val stepStatistics = Statistics("Step registration")

        try {
            fun calculateStatistics(filePath: String) {
                File(filePath).useLines {
                    it.filter { line -> line.contains("In kafkaMessageHandlerAsync: finished") }
                            .map { line -> extractNumber(line) }
                            .forEach { n -> stepStatistics.addTest(n) }
                }
            }

            files.forEach { calculateStatistics(it) }

            println(stepStatistics.resultAsDuration())
            logger.info(stepStatistics.resultAsDuration())

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
