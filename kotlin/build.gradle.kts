plugins {
    kotlin("jvm") version "2.3.10"
    id("org.jlleitschuh.gradle.ktlint") version "14.0.1"
    id("io.gitlab.arturbosch.detekt") version "1.23.8"
}

detekt {
    config.setFrom("$projectDir/detekt.yml")
    buildUponDefaultConfig = true
    allRules = false
    source.setFrom("src")
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    jvmTarget = "21"
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
