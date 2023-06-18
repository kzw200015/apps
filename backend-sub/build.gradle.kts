dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud:spring-cloud-loadbalancer")
    implementation("com.github.ben-manes.caffeine:caffeine")
    implementation("org.springframework:spring-context-support")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api")
    implementation(project(":backend-core"))
    implementation("org.springframework.boot:spring-boot-starter-freemarker")
}