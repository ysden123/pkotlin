/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.clazz.extension

fun String.test():Boolean{
    return !(this.length < 10 || this.isEmpty())
}

fun main() {
    val s1 = "12345678910111"
    println("s1.test() = ${s1.test()}")

    val s2 = "123"
    println("s2.test() = ${s2.test()}")

    val s3 = ""
    println("s3.test() = ${s3.test()}")
}