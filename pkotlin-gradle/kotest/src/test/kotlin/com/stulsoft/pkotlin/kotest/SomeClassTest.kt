/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.kotest

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

/**
 * @author Yuriy Stul
 */
class SomeClassTest : AnnotationSpec() {
    @BeforeEach
    fun beforeEach() {
        println("Before each test")
    }

    @Test
    fun fooTest() {
        val sc = SomeClass()
        val r = sc.foo(5)
        r shouldBe 128
        assertEquals(128, r)
    }

    @Test
    @Ignore
    fun foo2Test() {
        val sc = SomeClass()
        val r = sc.foo(5)
        r shouldBe 128
    }
}