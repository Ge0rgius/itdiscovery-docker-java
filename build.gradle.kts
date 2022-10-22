plugins {
    java
    eclipse
}

allprojects {
    group = "it.discovery"
}

subprojects {
    apply(plugin = "java")

    java.sourceCompatibility = JavaVersion.VERSION_19
    java.targetCompatibility = JavaVersion.VERSION_19

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }
    dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies:3.0.0-RC1"))
    }

    tasks.test {
        useJUnitPlatform()
    }
}

