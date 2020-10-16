/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.stream

import io.vertx.reactivex.core.Vertx
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/** Simple message consumer and message provider
 *
 * @author Yuriy Stul
 */
object StreamEx1 {
    private val logger: Logger = LoggerFactory.getLogger("")

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info("==>main")

        val vertx = Vertx.vertx()

        val ebAddress = StreamEx1.javaClass.name

        val messageConsumer = vertx.eventBus().consumer<String>(ebAddress)
        val messageProvider = vertx.eventBus().sender<String>(ebAddress)

        messageConsumer.handler { message -> logger.info("Received {}", message.body()) }

        for (i in 1..10) messageProvider.write("message # $i")
    }
}