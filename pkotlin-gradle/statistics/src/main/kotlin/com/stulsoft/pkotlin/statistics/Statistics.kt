/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.statistics

import org.apache.commons.lang3.time.DurationFormatUtils
import java.text.NumberFormat

/**
 * @author Yuriy Stul
 */
class Statistics(val title: String) {
    private var min = Long.MAX_VALUE
    private var max = 0L
    private var count = 0L
    private var total = 0L

    fun addTest(value: Long?) {
        if (value != null) {
            ++count
            total += value
            if (value > max) max = value
            if (value < min) min = value
        }
    }

    fun result(): String {
        return if (count > 0) {
            val average = total / count
            val nf = NumberFormat.getInstance()
            "$title: count=${nf.format(count)}, min=${nf.format(min)}, max=${nf.format(max)}, average=${nf.format(average)}"
        } else {
            "No data found"
        }
    }

    fun resultAsDuration(): String {
        return if (count > 0) {
            val average = total / count
            val format = "HH:mm:ss.SSS"
            val minText = DurationFormatUtils.formatDuration(min, format)
            val maxText = DurationFormatUtils.formatDuration(max, format)
            val averageText = DurationFormatUtils.formatDuration(average, format)
            val nf = NumberFormat.getInstance()
            "$title: count=${nf.format(count)}, min=$minText, max=$maxText, average=$averageText"
        } else {
            "No data found"
        }
    }
}