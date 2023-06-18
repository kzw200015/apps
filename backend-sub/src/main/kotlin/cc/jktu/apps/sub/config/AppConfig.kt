package cc.jktu.apps.sub.config

import cc.jktu.apps.common.config.OpenApiConfig
import cc.jktu.apps.common.util.CustomErrorAttributes
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.web.client.RestTemplate

@Configuration
@Import(OpenApiConfig::class, CustomErrorAttributes::class)
@EnableConfigurationProperties(SubConfig::class)
class AppConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}
