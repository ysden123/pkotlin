/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.stream

import io.vertx.reactivex.core.Vertx
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

/** Message consumer without message producer.
 *
 * @author Yuriy Stul
 */
object StreamEx2 {
    private val logger: Logger = LoggerFactory.getLogger("")

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info("==>main")
        val random = Random
        val n = 10
        val count = AtomicInteger(0)

        val vertx = Vertx.vertx()

        val ebAddress = StreamEx2.javaClass.name

        val messageConsumer = vertx.eventBus().consumer<String>(ebAddress)

        messageConsumer.handler { message ->
            run {
                vertx.setTimer(123L + random.nextInt(1000)) {
                    run {
                        logger.info("Received {}", message.body())
                        if (count.incrementAndGet() >= n)
                            vertx.close()
                    }
                }
            }
        }

        for (i in 1..n) vertx.eventBus().send(ebAddress, "message # $i")
    }
}