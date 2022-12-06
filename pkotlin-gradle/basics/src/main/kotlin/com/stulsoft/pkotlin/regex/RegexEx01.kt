/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.pkotlin.regex

fun validate(regex:Regex, test:String){
    println("'$test' matches to $regex: ${test.matches(regex)}")
}
fun t1() {
    val numberPattern = Regex("^-?\\d+$")
    validate(numberPattern, "123")
    validate(numberPattern, "123  ")
    validate(numberPattern, "123 ")
    validate(numberPattern, "-123")
    validate(numberPattern, "a123bc")
}

fun main() {
    t1()
}