package cc.jktu.apps.bot.config;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.ListenerHost;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BotLifeCycle implements SmartLifecycle {

    private final Bot bot;
    private final List<ListenerHost> eventHandlers;

    public BotLifeCycle(Bot bot, List<ListenerHost> eventHandlers) {
        this.bot = bot;
        this.eventHandlers = eventHandlers;
    }

    @Override
    public void start() {
        bot.login();
        eventHandlers.forEach(bot.getEventChannel()::registerListenerHost);
    }

    @Override
    public void stop() {
        bot.close();
    }

    @Override
    public boolean isRunning() {
        return bot.isOnline();
    }

}
