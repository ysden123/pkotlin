/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.generator

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */

val logger:Logger=LoggerFactory.getLogger("")

fun main() {
    test1()
    test2()
}

fun test1(){
    println("==>test1")
    val fibonacciSequence = sequence {
        var a = 0
        var b = 1

        yield(1)

        while (true) {
            yield(a + b)

            val tmp = a + b
            a = b
            b = tmp
        }
    }

    println(fibonacciSequence.take(8).toList())
}

fun test2(){
    logger.info("==>test2")
    val lazySeq = sequence {
        logger.info("Start")
        for(i in 1..5){
            yield(i)
            logger.info("Step")
        }
        logger.info("End")
    }

    lazySeq.take(3).forEach { logger.info("$it") }
}