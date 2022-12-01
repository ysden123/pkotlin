/*
 * Copyright (c) 2022. StulSoft
 */
package com.stulsoft.pkotlin.serialization

import com.stulsoft.pkotlin.serialization.data.Project
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.FileInputStream
import java.io.FileOutputStream

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    val data = Project("kotlin.serialization", "Kotlin")
    val str = Json.encodeToString(data)
    println(str)
    val data1 = Json.decodeFromString<Project>(str)
    println("data1 $data1")

    val fileName ="c:/work/data.json"
    Json.encodeToStream(data, FileOutputStream(fileName))

    val data2 = Json.decodeFromStream<Project>(FileInputStream(fileName))
    println("data2: $data2")
}
