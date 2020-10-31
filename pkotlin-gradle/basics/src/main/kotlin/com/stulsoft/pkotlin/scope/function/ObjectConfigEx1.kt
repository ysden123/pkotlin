/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.scope.function

/**
 * @author Yuriy Stul
 */
object ObjectConfigEx1 {
    class SomeClass(val name: String) {
        var age: Int = 0
        override fun toString(): String {
            return "SomeClass(name='$name', age=$age)"
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = SomeClass("test 1").apply {
            age = 123
        }

        println(sc)
    }
}