plugins {
    kotlin("jvm") version "2.3.0"
    id("org.jlleitschuh.gradle.ktlint") version "14.0.1"
}

group = "aoc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

sourceSets {
    main {
        kotlin.srcDirs("src")
        resources.srcDirs("src/resources")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("runDay") {
    mainClass.set(project.findProperty("mainClass") as String? ?: "")
    classpath = sourceSets["main"].runtimeClasspath
}
