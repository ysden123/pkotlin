/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun main() {
    val logger: Logger = LoggerFactory.getLogger("")
    logger.info("==>main")

    val app: HttpHandler = routes(
        "/ping" bind GET to { pingHandler() },
        "/greet/{name}" bind GET to { request -> greetHandler(request) },
        "/greet2" bind GET to { request -> greetHandler2(request) },
        "/greet3/{name}" bind GET to { request: Request ->
            val name: String? = request.path("name")
            greetHandler3(name)
        }
    )

    app.asServer(Jetty(8080)).start()
}

/**
 * URL: http://localhost:8080/ping
 */
fun pingHandler(): Response {
    val logger: Logger = LoggerFactory.getLogger("")
    logger.info("In pingHandler")
    return Response(OK).body("pong!")
}

/**
 * URL: http://localhost:8080/greet/{name}
 */
fun greetHandler(req: Request): Response {
    val logger: Logger = LoggerFactory.getLogger("")
    logger.info("In greetHandler")
    val name: String? = req.path("name")
    return Response(OK).body("hello ${name ?: "anon!"}")
}

/**
 * URL: http://localhost:8080/greet2?name=yuriy
 */
fun greetHandler2(req: Request): Response {
    val logger: Logger = LoggerFactory.getLogger("")
    logger.info("In greetHandler2")
    val name: String? = req.query("name")
    return Response(OK).body("hello ${name ?: "anon!"}")
}

/**
 * URL: http://localhost:8080/greet3/yuriy
 */
fun greetHandler3(name: String?): Response {
    val logger: Logger = LoggerFactory.getLogger("")
    logger.info("In greetHandler3")
    return Response(OK).body("hello ${name ?: "anon!"}")
}
