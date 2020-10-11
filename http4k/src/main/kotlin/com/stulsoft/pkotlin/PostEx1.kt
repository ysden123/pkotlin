/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import org.http4k.asString
import org.http4k.client.OkHttp
import org.http4k.core.HttpHandler
import org.http4k.core.Method.POST
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer

fun main() {
    println("==>main")

    val app: HttpHandler = routes(
            "/test" bind POST to { request -> postHandler(request) }
    )

    app.asServer(Jetty(9000)).start()

    val request: Request = Request(POST, "http://localhost:9000/test").body("Some body text")

    val client: HttpHandler = OkHttp()
    val networkResponse: Response = client(request)
    println("networkResponse: $networkResponse")
}

fun postHandler(request: Request): Response {
    println("In postHandler")
//    val body = String(request.body.stream.readAllBytes())
    val body = request.body.payload.asString()
    println("request body: $body")
    return Response(OK).body("Received request: $body")
}