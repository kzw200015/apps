package cc.jktu.apps.bot.config

import net.mamoe.mirai.utils.BotConfiguration
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope

@ConfigurationProperties("bot")
@RefreshScope
data class BotConfig(
    val qq: Long,
    val password: String,
    val protocol: BotConfiguration.MiraiProtocol
)