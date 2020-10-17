/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import java.net.InetSocketAddress
import java.net.URI

/**
 * @author Yuriy Stul
 */
object Config {
    fun uri() = URI("ws://localhost:8887")

    fun inetSocketAddress(): InetSocketAddress {
        val uri = uri()
        return InetSocketAddress(uri.host, uri.port)
    }
}