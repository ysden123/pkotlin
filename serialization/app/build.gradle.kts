/*
 * Copyright (c) 2022. StulSoft
 */

plugins {
    val kotlinVersion = "1.7.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
}

application {
    // Define the main class for the application.
    mainClass.set("com.stulsoft.pkotlin.serialization.AppKt")
}
