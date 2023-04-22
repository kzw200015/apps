package cc.jktu.apps.bot.service;

import lombok.Getter;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.ListenerHost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotService {

    private final List<ListenerHost> eventHandlers;

    @Getter
    private final Bot bot;

    public BotService(List<ListenerHost> eventHandlers, Bot bot) {
        this.eventHandlers = eventHandlers;
        this.bot = bot;
    }

    public void registerHandlers() {
        eventHandlers.forEach(bot.getEventChannel()::registerListenerHost);
    }

}
