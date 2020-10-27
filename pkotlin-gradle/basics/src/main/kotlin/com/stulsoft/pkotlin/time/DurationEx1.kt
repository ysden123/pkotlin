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
    private fun trimLeadingZerosTime(time: String): String {
        return if (!time.startsWith("00:") || time.length < 4)
            time
        else {
            val s = time.substring(3)
            return if (s.startsWith('0'))
                s.substring(1)
            else
                s
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val d1 = Duration.ofMillis(1234567)
        val d2 = Duration.ofMillis(2234567)
        val dif = d2 - d1
        println("dif=$dif")
        val s1 = DurationFormatUtils.formatDuration((2234567 - 1234567),
                "HH:mm:ss.SSS", true)
        println("s1=$s1")
        val s2 = DurationFormatUtils.formatDuration((2234567 - 1234567) / 3,
                "HH:mm:ss.SSS", true)
        println("s2=$s2")
        println("s2 (formatted)=${trimLeadingZerosTime(s2)}")
    }
}
