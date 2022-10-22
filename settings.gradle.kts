pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/release") }
        maven { url = uri("https://repo.spring.io/milestone") }
        gradlePluginPortal()
    }
}

rootProject.name = "docker-training"
include(
    "docker-task2",
    "docker-task3",
    "docker-task4",
    "docker-task6",
    "docker-task11",
    "docker-task12",
    "docker-task12:client",
    "docker-task12:server",
    "docker-task15",
    "docker-task17",
    "docker-task18"
)