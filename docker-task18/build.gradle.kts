import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("org.springframework.experimental.aot") version "0.12.1"
    `java-library`
}

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.5"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/release") }
}

tasks.test {
    useJUnitPlatform()
}


tasks.withType<BootBuildImage> {
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "true")
}