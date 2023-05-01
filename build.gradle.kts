import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.21"
    kotlin("kapt") version "1.8.21"
    id("com.google.devtools.ksp") version "1.8.21-1.0.11"
    kotlin("plugin.spring") version "1.8.21"
}

extra["springCloudVersion"] = "2022.0.0"
extra["springCloudAlibabaVersion"] = "2022.0.0.0-RC2"
extra["kapt.include.compile.classpath"] = false

allprojects {

    group = "cc.jktu"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }

}

subprojects {

    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "com.google.devtools.ksp")

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    java.sourceCompatibility = JavaVersion.VERSION_17

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
            mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
        }
        dependencies {
            dependency("com.github.ben-manes.caffeine:caffeine:3.1.5")
            dependency("com.baomidou:mybatis-plus-boot-starter:3.5.3.1")
            dependency("org.mindrot:jbcrypt:0.4")
            dependency("cn.dev33:sa-token-spring-boot3-starter:1.34.0")
            dependency("cn.dev33:sa-token-sso:1.34.0")
            dependency("cn.dev33:sa-token-dao-redis-jackson:1.34.0")
            dependency("cn.dev33:sa-token-reactor-spring-boot3-starter:1.34.0")
            dependency("org.springdoc:springdoc-openapi-starter-webmvc-api:2.1.0")
            dependency("org.springdoc:springdoc-openapi-starter-webflux-ui:2.1.0")
        }
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
        compileOnly("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        kapt("org.springframework.boot:spring-boot-configuration-processor")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

tasks.withType<BootJar> {
    enabled = false
}