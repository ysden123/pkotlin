/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.app

import org.slf4j.LoggerFactory


/**
 * @author Yuriy Stul
 */
object App {
    private val logger = LoggerFactory.getLogger("")

    @JvmStatic
    fun main(args: Array<String>) {
        println("==>main")
        logger.info("tt")
    }
}