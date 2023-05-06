dependencies {
    implementation("cn.dev33:sa-token-reactor-spring-boot3-starter")
    implementation("cn.dev33:sa-token-dao-redis-jackson")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    implementation("org.springframework.cloud:spring-cloud-loadbalancer")
    implementation("com.github.ben-manes.caffeine:caffeine")
    implementation("org.springframework:spring-context-support")
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui")
    implementation(project(":backend-core"))
}