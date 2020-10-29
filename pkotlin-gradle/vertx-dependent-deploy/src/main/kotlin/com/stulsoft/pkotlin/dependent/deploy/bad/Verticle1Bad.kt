/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.dependent.deploy.bad

import io.vertx.core.AbstractVerticle
import io.vertx.core.eventbus.Message
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */
class Verticle1Bad : AbstractVerticle() {
    private val logger = LoggerFactory.getLogger("")

    companion object {
        val EB_ADDRESS: String = Verticle1Bad::class.java.name
    }

    /**
     * If your verticle does a simple, synchronous start-up then override this method and put your start-up
     * code in here.
     * @throws Exception
     */
    override fun start() {
        logger.info("Starting...")
        vertx.eventBus().consumer(EB_ADDRESS, this::handler)
        vertx.eventBus().request<String>(Verticle2Bad.EB_ADDRESS, "Message from Verticle 1")
        { ar ->
            run {
                if (ar.succeeded()) {
                    logger.info("Received response from Verticle 2: ${ar.result().body()}")
                } else {
                    logger.error("Failed getting response from Verticle 2: ${ar.cause().message}")
                }
            }
        }
    }

    private fun handler(message: Message<String>) {
        logger.info("Handling ${message.body()}")
        message.reply("Done for ${message.body()}")
    }
}
