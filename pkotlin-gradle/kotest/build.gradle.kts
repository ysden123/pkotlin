/*
 * Copyright (c) 2020. Yuriy Stul
 */
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

group = "com.stulsoft.pkotlin"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
//    Logging
    implementation("org.apache.logging.log4j:log4j-core:${findProperty("logVersion")}")
    implementation("org.apache.logging.log4j:log4j-api:${findProperty("logVersion")}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${findProperty("logVersion")}")

    // test
    testImplementation("io.kotest:kotest-runner-junit5:${findProperty("kotestVersion")}") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core:${findProperty("kotestVersion")}") // for kotest core jvm assertions
    testImplementation("io.kotest:kotest-property:${findProperty("kotestVersion")}") // for kotest property test
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = findProperty("jvmTarget") as String?
}

tasks.withType<Test> {
    useJUnitPlatform()
}
