package cc.jktu.apps.bot.service

import net.mamoe.mirai.Bot
import net.mamoe.mirai.event.ListenerHost
import org.springframework.stereotype.Service

@Service
class BotService(private val eventHandlers: List<ListenerHost>, val bot: Bot) {

    fun registerHandlers() {
        eventHandlers.forEach {
            bot.eventChannel.registerListenerHost(it)
        }
    }
}
