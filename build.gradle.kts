plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "ru.dfhub"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.json:json:20240303")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}