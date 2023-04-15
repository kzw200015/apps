package cc.jktu.apps.bot.bot;

import kotlin.coroutines.CoroutineContext;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class BingChatHandler extends SimpleListenerHost {

    private final static RestTemplate REST_TEMPLATE = new RestTemplate();

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        log.error(exception.getLocalizedMessage());
    }


    @EventHandler
    public void onMessage(MessageEvent event) {

    }

}
