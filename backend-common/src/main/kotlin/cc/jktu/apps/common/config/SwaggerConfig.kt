package cc.jktu.apps.common.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(@Value("\${spring.application.name}") name: String?): OpenAPI {
        val openAPI = OpenAPI()
        openAPI.info(Info().title(name))
        return openAPI
    }
}
