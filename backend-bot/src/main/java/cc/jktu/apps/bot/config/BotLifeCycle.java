package cc.jktu.apps.bot.config;

import cc.jktu.apps.bot.service.BotService;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class BotLifeCycle implements SmartLifecycle {

    private final BotService botService;

    public BotLifeCycle(BotService botService) {
        this.botService = botService;
    }

    @Override
    public void start() {
        botService.getBot().login();
        botService.registerHandlers();
    }

    @Override
    public void stop() {
        botService.getBot().close();
    }

    @Override
    public boolean isRunning() {
        return botService.getBot().isOnline();
    }

}
