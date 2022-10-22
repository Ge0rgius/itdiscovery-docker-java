plugins {
    id("com.bmuschko.docker-spring-boot-application") version "7.1.0"
    id("org.springframework.boot") version "2.7.5"
}

/*apply plugin: 'com.bmuschko.docker-spring-boot-application'

docker {
    springBootApplication {
        baseImage = 'openjdk:19-alpine'
        images = ['spring-boot-docker:1.0']
    }
}
 */

tasks {
    bootJar {
        archiveFileName.set("spring-boot-docker.jar")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

