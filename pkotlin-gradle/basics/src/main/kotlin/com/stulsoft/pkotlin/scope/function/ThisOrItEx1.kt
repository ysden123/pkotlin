/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.scope.function

/**
 * @author Yuriy Stul
 */
object ThisOrItEx1 {
    @JvmStatic
    fun main(args: Array<String>) {
        test1()
    }

    private fun test1() {
        println("==>test1")
        val str = "Hello"
        // this
        // lambda receiver
        str.run {
            println("The receiver string length: $length")
            //println("The receiver string length: ${this.length}") // does the same
        }

        // it
        // lambda argument
        str.let {
            println("The receiver string's length is ${it.length}")
        }
    }
}