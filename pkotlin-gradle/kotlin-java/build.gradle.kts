/*
 * Copyright (c) 2020. Yuriy Stul
 */
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}

group = "com.stulsoft.pkotlin"
version = "1.0.0"

repositories {
    mavenCentral()
}

val logVersion = "2.13.3"
val kotestVersion = "4.3.0"

dependencies {
//    Logging
    implementation("org.apache.logging.log4j:log4j-core:$logVersion")
    implementation("org.apache.logging.log4j:log4j-api:$logVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$logVersion")

    // test
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion") // for kotest core jvm assertions
    testImplementation("io.kotest:kotest-property:$kotestVersion") // for kotest property test
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
