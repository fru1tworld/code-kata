plugins {
    kotlin("jvm") version "2.3.10"
    id("org.jlleitschuh.gradle.ktlint") version "14.0.1"
    // detekt 1.x doesn't support JDK 25, detekt 2.0 is alpha with breaking config changes
    // using ktlint only for now
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
    jvmToolchain(25)
}

sourceSets {
    main {
        kotlin.srcDirs("src")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("runDay") {
    mainClass.set(project.findProperty("mainClass") as String? ?: "")
    classpath = sourceSets["main"].runtimeClasspath
}
