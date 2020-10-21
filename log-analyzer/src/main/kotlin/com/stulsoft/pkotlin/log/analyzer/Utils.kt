/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.log.analyzer

import java.text.DateFormat
import java.time.Duration.parse
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * @author Yuriy Stul
 */
object Utils {
    //[2020-10-20T10:52:37.192605]
    fun logTime(line: String): Long {
        val lineWithDate = line
                .replace("[", "")
                .replace("] In", "000")
                .replace("]", "")
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
        val dateTime = LocalDateTime.parse(lineWithDate, formatter)
        return dateTime.toInstant(ZoneOffset.UTC).toEpochMilli()
    }
}
