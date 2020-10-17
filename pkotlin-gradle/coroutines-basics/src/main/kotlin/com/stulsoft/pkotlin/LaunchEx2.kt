/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author Yuriy Stul
 */
private val logger: Logger = LoggerFactory.getLogger("")

fun main() {
    logger.info("Started")
    val c = AtomicInteger()
    val startTime = System.currentTimeMillis()
    val n = 10_000
    val countDown = CountDownLatch(n)

    for (i in 1..n)
        GlobalScope.launch {
            c.addAndGet(i)
            countDown.countDown()
        }
    countDown.await()
    logger.info("Completed: {} in {} msec", c.get(), System.currentTimeMillis() - startTime)
}
