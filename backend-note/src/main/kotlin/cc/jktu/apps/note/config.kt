package cc.jktu.apps.note

import cc.jktu.apps.common.config.MybatisPlusConfig
import cc.jktu.apps.common.config.OpenApiConfig
import cc.jktu.apps.common.config.TimeMetaObjectHandler
import cc.jktu.apps.common.util.CustomErrorAttributes
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    MybatisPlusConfig::class,
    TimeMetaObjectHandler::class,
    OpenApiConfig::class,
    CustomErrorAttributes::class
)
@EnableFeignClients("cc.jktu.apps.common.rpc")
class AppConfig