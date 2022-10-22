dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    testImplementation("org.testcontainers:junit-jupiter:1.17.5")
    testImplementation("org.testcontainers:mysql:1.17.5")
    runtimeOnly("mysql:mysql-connector-java")
}
tasks.test {
    useJUnitPlatform()
}


