package cc.jktu.apps.auth.config

import cc.jktu.apps.common.config.MybatisPlusConfig
import cc.jktu.apps.common.config.SwaggerConfig
import cc.jktu.apps.common.config.TimeMetaObjectHandler
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(MybatisPlusConfig::class, TimeMetaObjectHandler::class, SwaggerConfig::class)
class AuthConfig
