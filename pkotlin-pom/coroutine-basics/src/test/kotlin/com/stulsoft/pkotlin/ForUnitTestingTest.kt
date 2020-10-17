/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin

/**
 * @author Yuriy Stul
 */
import org.junit.Test

import org.junit.Assert.*

class ForUnitTestingTest {

    @Test
    fun foo() {
        val i = ForUnitTesting()
        assertEquals("done", i.foo())
    }
}
