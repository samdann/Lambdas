import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    application
}

group = "com.blackchain"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

buildscript {
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.3.0")
    }
}
application {
    mainClass = "com.blackchain.MainKt"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    val cdkVersion = "2.207.0"
    implementation(platform("aws.sdk.kotlin:bom:1.3.112"))
    implementation("aws.sdk.kotlin:lambda")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
//    implementation("software.amazon.awscdk:core:${cdkVersion}")
//    implementation("software.amazon.awscdk:lambda:${cdkVersion}")
//    implementation("software.amazon.awscdk:apigateway:${cdkVersion}")
    implementation("software.amazon.awscdk:aws-cdk-lib:$cdkVersion")


    testImplementation(kotlin("test"))
    testImplementation("org.http4k:http4k-testing-strikt:5.6.4.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0")
}

tasks {
    shadowJar {
        archiveBaseName.set("Lambdas")
        archiveClassifier.set("")
        archiveVersion.set("1.0-SNAPSHOT")
    }
}

val disabledTasks = listOf("startScripts", "distZip", "distTar", "startShadowScripts", "shadowDistTar", "shadowDistZip")

disabledTasks.forEach { taskName ->
    tasks.named(taskName) {
        enabled = false
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
