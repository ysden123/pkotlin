/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.scope.function

/**
 * @author Yuriy Stul
 */
object LetEx1 {
    data class Person(val name:String, val age:Int)

    @JvmStatic
    fun main(args: Array<String>) {
        Person("test 1", 22).let {
            println(it)
            println("age: ${it.age}")
        }

        val p = Person("test 2", 23)
        p.let {
            println(it)
            println("age: ${it.age}")
        }
    }
}