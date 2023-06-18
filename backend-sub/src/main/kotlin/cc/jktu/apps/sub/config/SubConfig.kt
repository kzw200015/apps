package cc.jktu.apps.sub.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope

@ConfigurationProperties("sub")
@RefreshScope
data class SubConfig(
    val apiUrl: String
)
