/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import org.slf4j.LoggerFactory
import java.net.URI

/**
 * @author Yuriy Stul
 */
class Client(uri: URI) : WebSocketClient(uri) {
    private val logger = LoggerFactory.getLogger("")

    init {
        logger.info("Creating client with $uri")
    }

    override fun onOpen(serverHandshake: ServerHandshake?) {
        logger.info("Connected")
        send("Hello!")
    }

    override fun onMessage(message: String?) {
        logger.info("Received $message")
    }

    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        logger.info("Closed with $code code, [$reason] reason, and [$remote] remote")
    }

    override fun onError(error: Exception?) {
        if (error != null) {
            logger.error("${error.message}")
        }
    }
}

fun main() {
    val client = Client(Config.uri())
    client.connect()
}