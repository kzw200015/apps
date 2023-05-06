package cc.jktu.apps.bot.service.handler

import cc.jktu.apps.common.util.log
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.SimpleListenerHost
import net.mamoe.mirai.event.events.MessageEvent
import org.springframework.stereotype.Component
import kotlin.coroutines.CoroutineContext


@Component
object MessageHandler : SimpleListenerHost() {

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        log.error(exception.localizedMessage)
        exception.printStackTrace()
    }

    @EventHandler
    suspend fun MessageEvent.handle() {

    }
}