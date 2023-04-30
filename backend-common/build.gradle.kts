import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    compileOnly("com.baomidou:mybatis-plus-boot-starter")
    compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")
    compileOnly("org.springdoc:springdoc-openapi-starter-webmvc-api")
    compileOnly("org.mindrot:jbcrypt")
    compileOnly("org.springframework.boot:spring-boot-starter-web")
}

tasks.withType<Jar> {
    enabled = true
}

tasks.withType<BootJar> {
    enabled = false
}

