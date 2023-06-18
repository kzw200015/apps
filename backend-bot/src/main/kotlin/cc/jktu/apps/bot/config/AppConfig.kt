package cc.jktu.apps.bot.config

import cc.jktu.apps.common.config.MybatisPlusConfig
import cc.jktu.apps.common.config.OpenApiConfig
import cc.jktu.apps.common.config.TimeMetaObjectHandler
import cc.jktu.apps.common.util.CustomErrorAttributes
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory.INSTANCE.newBot
import net.mamoe.mirai.auth.BotAuthorization
import net.mamoe.mirai.utils.BotConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import java.io.File

@Configuration
@Import(MybatisPlusConfig::class, TimeMetaObjectHandler::class, OpenApiConfig::class, CustomErrorAttributes::class)
@EnableConfigurationProperties(BotConfig::class)
class AppConfig {

    @Bean
    fun bot(botConfig: BotConfig): Bot {
        val botConfiguration = BotConfiguration()
        botConfiguration.protocol = botConfig.protocol
        botConfiguration.fileBasedDeviceInfo()
        botConfiguration.workingDir = File("bot-data")
        return newBot(botConfig.qq, BotAuthorization.byQRCode(), botConfiguration)
    }
}
