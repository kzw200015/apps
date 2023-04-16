package cc.jktu.apps.bot.config;

import cc.jktu.apps.common.config.MybatisPlusConfig;
import cc.jktu.apps.common.config.SwaggerConfig;
import cc.jktu.apps.common.config.TimeMetaObjectHandler;
import lombok.Data;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.auth.BotAuthorization;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.File;

@Configuration
@Import({MybatisPlusConfig.class, TimeMetaObjectHandler.class, SwaggerConfig.class})
@ConfigurationProperties("bot")
@Data
public class BotConfig {

    private Long qq;
    private String password;
    private BotConfiguration.MiraiProtocol protocol;

    @Bean
    public Bot bot() {
        final BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setProtocol(BotConfiguration.MiraiProtocol.ANDROID_WATCH);
        botConfiguration.fileBasedDeviceInfo();
        botConfiguration.setWorkingDir(new File("bot-data"));

        return BotFactory.INSTANCE.newBot(qq, BotAuthorization.byQRCode(), botConfiguration);
    }

}