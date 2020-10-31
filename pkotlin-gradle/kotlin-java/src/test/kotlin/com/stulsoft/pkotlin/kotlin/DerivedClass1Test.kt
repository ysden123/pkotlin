/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.kotlin

import com.stulsoft.pkotlin.java.DerivedClass1
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class DerivedClass1Test : AnnotationSpec(){
    @Test
    fun test1(){
        val dr = DerivedClass1("test 22", 15)
        dr.nameAndAge() shouldBe "test 22 -> 15"
    }
}
