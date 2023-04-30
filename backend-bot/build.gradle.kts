dependencies {
    val miraiVersion = "2.15.0-M1"

    implementation("net.mamoe:mirai-core-jvm:${miraiVersion}")
    implementation("net.mamoe:mirai-logging-slf4j:${miraiVersion}")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.baomidou:mybatis-plus-boot-starter")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud:spring-cloud-loadbalancer")
    implementation("com.github.ben-manes.caffeine:caffeine")
    implementation("org.springframework:spring-context-support")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api")
    implementation(project(":backend-common"))
    runtimeOnly("com.mysql:mysql-connector-j")
}