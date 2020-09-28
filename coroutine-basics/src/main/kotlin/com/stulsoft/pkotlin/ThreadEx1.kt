/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

private val logger: Logger = LoggerFactory.getLogger("")

/**
 * @author Yuriy Stul
 */
fun main() {
    val c = AtomicInteger()

    val startTime = System.currentTimeMillis()

    logger.info("Started")
    val n = 10_000
    val countDown = CountDownLatch(n)
    for (i in 1..n)
        thread(start = true) {
            c.addAndGet(i)
            countDown.countDown()
        }
    countDown.await()
    logger.info("Completed: {} in {} msec", c.get(), System.currentTimeMillis() - startTime)
}
