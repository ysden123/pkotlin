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

val http4kVersion = "3.265.0"

dependencies {
//  HTTP4K
	implementation("org.http4k:http4k-core:$http4kVersion")
	implementation("org.http4k:http4k-server-jetty:$http4kVersion")
	implementation("org.http4k:http4k-client-okhttp:$http4kVersion")
    testImplementation(kotlin("test-junit"))
//    Logging
    implementation("org.apache.logging.log4j:log4j-core:${findProperty("logVersion")}")
    implementation("org.apache.logging.log4j:log4j-api:${findProperty("logVersion")}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${findProperty("logVersion")}")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = findProperty("jvmTarget") as String?
}

/*
application {
    mainClass.set("com.stulsoft.pkotlin.gradle1.MainKt")
}
*/