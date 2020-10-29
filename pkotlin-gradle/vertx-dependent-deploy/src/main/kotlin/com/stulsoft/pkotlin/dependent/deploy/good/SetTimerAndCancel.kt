/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.dependent.deploy.good

import io.vertx.core.Vertx
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */
object SetTimerAndCancel {
    private val logger=LoggerFactory.getLogger("")
    @JvmStatic
    fun main(args: Array<String>) {
        var vertx = Vertx.vertx()
        test1(vertx)
        test2(vertx)
    }
    
    private fun test1(vertx:Vertx){
        var counter = 0
        val timerId = vertx.setPeriodic(1000) {
            logger.info("timerId=$it")
            if (++counter > 3) vertx.cancelTimer(it)
        }
        logger.info("timerId=$timerId")
    }
    
    private fun test2(vertx:Vertx){
        var counter = 0
        val timerId = vertx.setPeriodic(1000) {
            logger.info("timerId=$it")
            if (++counter > 3) vertx.cancelTimer(it)
        }
        logger.info("timerId=$timerId")
    }
}
