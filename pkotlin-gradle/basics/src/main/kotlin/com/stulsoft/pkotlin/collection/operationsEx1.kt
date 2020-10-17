/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.collection

/**
 * @author Yuriy Stul
 */

fun main() {
    fun test1() {
        println("==>test1")
        val numbers = listOf("one", "two", "three", "four")
        numbers.filter { it.length > 3 }  // nothing happens with `numbers`, result is lost
        println("numbers are still $numbers")
        val longerThan3 = numbers.filter { it.length > 3 } // result is stored in `longerThan3`
        println("numbers longer than 3 chars are $longerThan3")
    }

    fun test2(){
        println("==>test2")
        val numbers = listOf("one", "two", "three", "four")
        val filterResults = mutableListOf<String>()  //destination object
        numbers.filterTo(filterResults) { it.length > 3 }
        numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
        println(filterResults) // contains results of both operations
    }

    test1()
    test2()
}