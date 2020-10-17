/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */
object LaunchEx1 {
    private val logger: Logger = LoggerFactory.getLogger("")

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info("Start")
        GlobalScope.launch {
            delay(1000)
            logger.info("Hello")
        }

        Thread.sleep(2000) // wait for 2 seconds
        logger.info("Stop")
    }
}
