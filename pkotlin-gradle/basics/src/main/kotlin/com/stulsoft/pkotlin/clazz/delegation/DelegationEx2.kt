/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz.delegation

/*
Simple delegation example. Call function from delegated interface.
 */


interface SomeInterface2 {
    fun foo(): String
}

class SomeInterface2Impl(val name: String) : SomeInterface2 {
    override fun foo() = "$name handled"
}

class SomeClassWithDelegation2(private val si: SomeInterface2) : SomeInterface2 by si {
    fun bar() {
        println("In bar. foo: ${foo()}")
    }
}

fun main() {
    val si = SomeInterface2Impl("test 2")
    val scwd = SomeClassWithDelegation2(si)

    scwd.bar()
}