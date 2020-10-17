/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author Yuriy Stul
 */

fun job() = GlobalScope.launch {
    delay(1000)
    println("Completed")
}

suspend fun main() {
    println("==>main")
     val job = job()
    println("P 001")
    job.join()
    println(" P 002")
}