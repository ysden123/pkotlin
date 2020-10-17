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
val vertxVersion = "3.9.3"
val reactivexVersion = "2.2.19"

dependencies {
    testImplementation(kotlin("test-junit"))
//    Vertx
    implementation("io.vertx:vertx-core:$vertxVersion")
    implementation("io.vertx:vertx-rx-java2:$vertxVersion")
    implementation("io.vertx:vertx-reactive-streams:$vertxVersion")
//    RxJava
    implementation("io.reactivex.rxjava2:rxjava:$reactivexVersion")
//    Logging
    implementation("org.apache.logging.log4j:log4j-core:$logVersion")
    implementation("org.apache.logging.log4j:log4j-api:$logVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$logVersion")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}


application {
    mainClass.set("com.stulsoft.pkotlin.stream.StreamEx1")
}
