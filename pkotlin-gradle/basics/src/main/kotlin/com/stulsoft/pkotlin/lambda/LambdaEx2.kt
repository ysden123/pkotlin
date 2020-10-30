/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.lambda

/**
 * @author Yuriy Stul
 */
object LambdaEx2 {
    private fun f1(k: Int, f: (Int) -> Int): Int {
        return f(k)
    }

    private fun foo(p1: Int, f1: (Int) -> Int, f2: (Int) -> Int): Int {
        return f1(f2(p1))
    }

    private fun bar(p:String, log:(String) -> Unit){
        log(p)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("${f1(123) { it + 22 }}")
        println("${f1(15) { it + 22 }}")

        val r3 = f1(3) { i -> i + 4 }
        println("r3=$r3")

        val r4 = foo(123, { it + 2 }, { it * 50 })
        println("r4=$r4")
        println("${foo(321, { it + 2 }, { it * 50 })}")

        val r5 = foo(76,
                {
                    println("1 it=$it")
                    it * 54
                },
                {
                    println("2 it=$it")
                    it - 17
                })
        println("r5=$r5")

        bar("test text 1"){println("In logger: it is a $it")}
        bar("test text 2"){println("In logger: it is a $it")}
    }
}
