/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.time

import org.apache.commons.lang3.time.DurationFormatUtils
import java.time.Duration

/**
 * @author Yuriy Stul
 */
object DurationEx1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val d1 = Duration.ofMillis(1234567)
        val d2 =  Duration.ofMillis(2234567)
        val dif= d2 - d1
        println("dif=$dif")
        val s1 = DurationFormatUtils.formatDuration((2234567 - 1234567),
                "HH:mm:ss.SSS", true)
        println("s1=$s1")
        val s2 = DurationFormatUtils.formatDuration((2234567 - 1234567)/3,
                "HH:mm:ss.SSS", true)
        println("s2=$s2")
    }
}
