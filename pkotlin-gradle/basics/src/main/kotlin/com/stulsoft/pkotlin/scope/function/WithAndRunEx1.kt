/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.scope.function

/**
 * @author Yuriy Stul
 */
object WithAndRunEx1 {
    class SomeClass(val name: String) {
        var age: Int = 0
        override fun toString(): String {
            return "SomeClass(name='$name', age=$age)"
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        // with
        val scForWith = SomeClass("test 1")
        with(scForWith) {
            age = 123
        }
        println(scForWith)  // SomeClass value (toString)

        // run
        val scForRun = SomeClass("test 2")
                .run {
                    age = 456
                }
        println(scForRun)   // Unit
    }

}