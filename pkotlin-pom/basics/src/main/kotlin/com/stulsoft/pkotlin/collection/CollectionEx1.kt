/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.collection

/**
 * @author Yuriy Stul
 */

fun main(){
    println("==>main")
    test1()
    test2()
}
fun test1() {
    println("==>test1")
    val col = listOf("one", "two", "three")
    println("col:")
    printAll(col)

    val set = setOf("one", "two", "three")
    println("set:")
    printAll(set)

    val setSorted = sortedSetOf("one", "two", "three")
    println("setSorted:")
    printAll(setSorted)
}

fun printAll(collection: Collection<String>) {
    collection.forEach { println(it) }
}

fun test2(){
    println("==>test2")
    val doubled = List(3) { it * 2 }
    println("doubled:")
    println(doubled)

    val ss = List(3){"item $it"}
    println("ss:")
    println(ss)
}