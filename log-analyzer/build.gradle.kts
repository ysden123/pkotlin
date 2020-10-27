/*
 * Copyright (c) 2020. Yuriy Stul
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
}
group = "com.stulsoft.pkotlin"
version = "1.1.1"

repositories {
    mavenCentral()
}

val logVersion = "2.13.3"

dependencies {
    implementation("org.apache.commons:commons-lang3:3.11")
//    Logging
    implementation("org.apache.logging.log4j:log4j-core:$logVersion")
    implementation("org.apache.logging.log4j:log4j-api:$logVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$logVersion")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}


application {
    mainClass.set("com.stulsoft.pkotlin.log.analyzer.EtlExecutions")
}
