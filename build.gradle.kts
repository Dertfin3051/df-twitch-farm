plugins {
    id("java")
}

group = "ru.dfhub"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.json:json:20240303")
}

tasks.test {
    useJUnitPlatform()
}