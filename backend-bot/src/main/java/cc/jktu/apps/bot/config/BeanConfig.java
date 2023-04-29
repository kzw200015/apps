package cc.jktu.apps.bot.config;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.auth.BotAuthorization;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class BeanConfig {

    @Bean
    public Bot bot(BotConfig botConfig) {
        final BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setProtocol(botConfig.getProtocol());
        botConfiguration.fileBasedDeviceInfo();
        botConfiguration.setWorkingDir(new File("bot-data"));
        return BotFactory.INSTANCE.newBot(botConfig.getQq(), BotAuthorization.byQRCode(), botConfiguration);
    }

}
