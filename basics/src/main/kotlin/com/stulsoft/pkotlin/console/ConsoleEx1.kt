/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.console

/**
 * @author Yuriy Stul
 */

fun main() {
    println("Enter a text")
    val answer1 = readLine()
    println("answer1: $answer1")

    println("Enter a text")
    val answer2 = readLine()!!.split(' ')
    println("answer1: $answer2")
}