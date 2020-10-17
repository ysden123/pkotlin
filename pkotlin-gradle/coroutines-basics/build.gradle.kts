/*
 * Copyright (c) 2020. Yuriy Stul
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
}
group = "com.stulsoft.pkotlin"
version = "1.0.0"

repositories {
    mavenCentral()
}

val logVersion = "2.13.3"

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
//    Logging
    implementation("org.apache.logging.log4j:log4j-core:$logVersion")
    implementation("org.apache.logging.log4j:log4j-api:$logVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$logVersion")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

/*
application {
    mainClass.set("com.stulsoft.pkotlin.gradle1.MainKt")
}
*/
