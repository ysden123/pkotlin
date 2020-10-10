/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz

class ITest1Impl : ITest1, ITest2 {
    override fun foo(n: String) {
        println("foo => n: $n")
    }

    override fun foo2(n: String) {
        println("foo2 => n: $n")
    }
}

fun main() {
    val t1 = ITest1Impl()
    t1.foo("test")
    t1.foo2("test 2")
}