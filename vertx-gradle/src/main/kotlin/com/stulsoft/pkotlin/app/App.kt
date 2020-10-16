/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.app

import io.vertx.reactivex.core.Vertx
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */
object App {

    @JvmStatic
    fun main(args: Array<String>) {
        val logger: Logger = LoggerFactory.getLogger("com.stulsoft.pkotlin.app.App")
        logger.info("==>main")

        val vertx = Vertx.vertx()

        vertx.setTimer(500){
            logger.info("In thread")
            vertx.close()
        }
    }
}