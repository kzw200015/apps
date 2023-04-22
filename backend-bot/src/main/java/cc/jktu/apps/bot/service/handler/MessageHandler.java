package cc.jktu.apps.bot.service.handler;

import kotlin.coroutines.CoroutineContext;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageHandler extends SimpleListenerHost {

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        log.error(exception.getLocalizedMessage());
        exception.printStackTrace();
    }

    @EventHandler
    public void onMessage(GroupMessageEvent event) {
        log.info(event.getMessage().contentToString());
    }

    @EventHandler
    public void onMessage(FriendMessageEvent event) {
        log.info(event.getMessage().contentToString());
    }

}
