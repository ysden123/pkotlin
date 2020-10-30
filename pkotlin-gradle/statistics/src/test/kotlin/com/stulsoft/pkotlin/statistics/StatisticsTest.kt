/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author Yuriy Stul
 */
class StatisticsTest {
    @Test
    fun resultTest(){
        val title = "Test"
        val s = Statistics(title)
        s.addTest(1)
        val r = s.result()
        val expected = "Test: count=1, min=1, max=1, average=1"
        assertEquals(expected, r)
    }

    @Test
    fun resultAsDurationTest(){
        val title = "Test"
        val s = Statistics(title)
        s.addTest(1)
        val r = s.resultAsDuration()
        val expected = "Test: count=1, min=00:00:00.001, max=00:00:00.001, average=00:00:00.001"
        assertEquals(expected, r)
    }
}