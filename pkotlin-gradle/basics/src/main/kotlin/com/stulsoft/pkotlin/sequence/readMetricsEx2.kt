/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.sequence

import java.io.File

/**
 * @author Yuriy Stul
 */
fun main() = try {
    var startLine: String? = null
    var endLine: String?
    var counter = 0
    File("basics/data/file2.txt").useLines {
        println("start")
        it.filter { s -> s.startsWith("start") || s.startsWith("end") }
                .forEach {
                    run {
                        if (it.startsWith("start")) {
                            startLine = it
                        } else {
                            endLine = it
                            ++counter
                            println("$startLine -> $endLine, counter=$counter")
                        }
                    }
                }
        println("end")
    }
} catch (ex: Exception) {
    println("Error: ${ex.message}")
}