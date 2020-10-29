/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.dependent.deploy.good

import io.vertx.core.Vertx
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */
object AppGood{
    private val logger = LoggerFactory.getLogger("")

    @JvmStatic
    fun main(args: Array<String>) {
        val vertx = Vertx.vertx()

        // Forced delay in Verticle1 deployment
        vertx.setTimer(1000){
            deploy(vertx, Verticle1Good::class.java.name)
        }
        deploy(vertx, Verticle2Good::class.java.name)
    }

    private fun deploy(vertx: Vertx, verticleName: String) {
        vertx.deployVerticle(verticleName) { ar ->
            run {
                if (ar.succeeded()) {
                    logger.info("Succeeded to deploy ${verticleName}")
                }
            }
        }
    }

}
