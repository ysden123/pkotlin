/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz

/** DerivedEx1 class extends BaseClass1 and implements ITest1 and ITest2 interfaces.
 *
 * @author Yuriy Stul
 */
class DerivedEx1 : BaseClass1(), ITest1, ITest2 {
    override fun foo(n: String) {
        println("foo ==> n = $n")
    }

    override fun foo2(n: String) {
        println("foo2 ==> n = $n")
    }
}

fun main() {
    val d = DerivedEx1()
    d.foo("test 1")
    d.foo2("test 2")
    println(d.baseFun(123))
}