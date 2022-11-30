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

val junit5Version = "5.9.1"

dependencies {
    implementation("org.apache.commons:commons-lang3:${findProperty("commonsLang3Version")}")

//    Logging
    implementation("org.apache.logging.log4j:log4j-core:${findProperty("logVersion")}")
    implementation("org.apache.logging.log4j:log4j-api:${findProperty("logVersion")}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${findProperty("logVersion")}")

    // test
//    testImplementation(kotlin("test-junit"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit5Version")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = findProperty("jvmTarget") as String?
}

tasks.withType<Test> {
    useJUnitPlatform()
}
