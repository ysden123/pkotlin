/*
 * Copyright (c) 2020. Yuriy Stul
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}
group = "com.stulsoft.pkotlin"
version = "1.0.0"

repositories {
    mavenCentral()
}


dependencies {
    testImplementation(kotlin("test-junit"))
//    Logging
    implementation("org.apache.logging.log4j:log4j-core:${findProperty("logVersion")}")
    implementation("org.apache.logging.log4j:log4j-api:${findProperty("logVersion")}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${findProperty("logVersion")}")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = findProperty("jvmTarget") as String?
}


application {
    mainClass.set("com.stulsoft.pkotlin.gradle1.MainKt")
}
