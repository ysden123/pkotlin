/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.sequence

import java.io.File

/**
 * @author Yuriy Stul
 */

fun main() {
    try {
        File("basics/data/file1.txt").useLines {
            println("start")
            it.forEach { line -> println(line) }
            println("end")
        }
    } catch (ex: Exception) {
        println("Error: ${ex.message}")
    }
}