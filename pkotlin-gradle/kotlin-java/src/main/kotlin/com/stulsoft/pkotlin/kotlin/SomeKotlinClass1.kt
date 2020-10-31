/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pkotlin.kotlin

/**
 * @author Yuriy Stul
 */
open class SomeKotlinClass1(val name:String,val age:Int) {
    fun nameAndAge():String{
        return "$name -> $age"
    }
}