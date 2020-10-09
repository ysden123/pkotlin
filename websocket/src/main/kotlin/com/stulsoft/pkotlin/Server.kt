/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import org.slf4j.LoggerFactory
import java.net.InetSocketAddress
import kotlin.concurrent.timer
import kotlin.random.Random

/**
 * @author Yuriy Stul
 */
class Server(address: InetSocketAddress) : WebSocketServer(address) {
    private val logger = LoggerFactory.getLogger("")

    private val random = Random

    init {
        logger.info("Creating server with $address")
    }

    override fun onOpen(webSocket: WebSocket?, clientHandshake: ClientHandshake?) {
        webSocket?.send("Welcome to the server") //This method sends a message to the new client
        if (clientHandshake != null) {
            //This method sends a message to all clients connected
            broadcast("New connection: ${clientHandshake.resourceDescriptor} ")
            logger.info("New connection: ${clientHandshake.resourceDescriptor} ")
        }

    }

    override fun onClose(webSocket: WebSocket?, code: Int, reason: String?, remote: Boolean) {
        if (webSocket != null) {
            logger.info("Closed ${webSocket.remoteSocketAddress} with $code code and [$reason] reason. Remote is $remote")
        }
    }

    override fun onMessage(webSocket: WebSocket?, message: String?) {
        if (webSocket != null)
            logger.info("Received [$message] from ${webSocket.remoteSocketAddress}")
    }

    override fun onError(webSocket: WebSocket?, error: Exception?) {
        if (webSocket != null && error != null) {
            logger.error("${error.message} on ${webSocket.remoteSocketAddress}")
        }
    }

    override fun onStart() {
        logger.info("Starting with $address")
        var messageNumber = 1
        timer("server-timer", false, period = 1000) {
            Thread.sleep(123L + random.nextLong(1500))
            broadcast("message # ${messageNumber++}")
        }
    }
}

fun main() {
    val server = Server(Config.inetSocketAddress())
    server.run()
}