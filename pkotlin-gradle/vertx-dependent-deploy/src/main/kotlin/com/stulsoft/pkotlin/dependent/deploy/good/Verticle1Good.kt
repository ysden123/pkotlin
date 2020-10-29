/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.dependent.deploy.good

import io.vertx.core.AbstractVerticle
import io.vertx.core.eventbus.Message
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Stul
 */
class Verticle1Good : AbstractVerticle() {
    private val logger = LoggerFactory.getLogger("")

    companion object {
        val EB_ADDRESS: String = Verticle1Good::class.java.name
    }

    /**
     * If your verticle does a simple, synchronous start-up then override this method and put your start-up
     * code in here.
     * @throws Exception
     */
    override fun start() {
        logger.info("Starting...")
        vertx.eventBus().consumer(EB_ADDRESS, this::handler)

        val retry = 10
        var counter = 0

        vertx.setPeriodic(1000) {
            vertx.eventBus().request<String>(Verticle2Good.EB_ADDRESS, "Message from Verticle 1")
            { ar ->
                run {
                    logger.debug("timer ID=$it")
                    if (ar.succeeded()) {
                        logger.info("Received response from Verticle 2: ${ar.result().body()}")
                        vertx.cancelTimer(it)
                    } else {
                        if (++counter > retry) {
                            logger.error("Failed getting response from Verticle 2: ${ar.cause().message}")
                            vertx.cancelTimer(it)
                        }
                    }
                }
            }
        }
    }

    private fun handler(message: Message<String>) {
        logger.info("Handling ${message.body()}")
        message.reply("Done for ${message.body()}")
    }
}
