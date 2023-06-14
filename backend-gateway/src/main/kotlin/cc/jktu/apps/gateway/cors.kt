package cc.jktu.apps.gateway

import org.springframework.cloud.gateway.config.GlobalCorsProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource

@Configuration
class CorsConfig {

    @Bean
    @Order(-1)
    fun corsWebFilter(globalCorsProperties: GlobalCorsProperties) =
        CorsWebFilter(UrlBasedCorsConfigurationSource().apply {
            setCorsConfigurations(globalCorsProperties.corsConfigurations)
        })
}