/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz.delegation

/*
Simple delegation example
 */

interface SomeInterface {
    fun foo()
}

class SomeInterfaceImpl(val name: String) : SomeInterface {
    override fun foo() {
        println("name is $name")
    }
}

class SomeClassWithDelegation(private val si: SomeInterface) : SomeInterface by si {
    fun bar() {
        println("In bar")
    }
}

fun main() {
    val si = SomeInterfaceImpl("test 1")
    val scwd = SomeClassWithDelegation(si)

    scwd.foo()
    scwd.bar()
}