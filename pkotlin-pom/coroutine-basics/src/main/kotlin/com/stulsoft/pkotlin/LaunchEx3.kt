/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */

private val logger: Logger = LoggerFactory.getLogger("")

fun main() {
    logger.info("Start")
    GlobalScope.launch {
        delay(1000)
        logger.info("Hello")
    }
    runBlocking {
        logger.info("Wait")
        delay(2000)
        logger.info("Completed waiting")
    }
}