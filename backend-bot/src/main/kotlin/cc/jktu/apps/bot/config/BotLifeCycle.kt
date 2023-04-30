package cc.jktu.apps.bot.config

import cc.jktu.apps.bot.service.BotService
import kotlinx.coroutines.runBlocking
import org.springframework.context.SmartLifecycle
import org.springframework.stereotype.Component

@Component
class BotLifeCycle(private val botService: BotService) : SmartLifecycle {

    override fun start() {
        runBlocking { botService.bot.login() }
        botService.registerHandlers()
    }

    override fun stop() {
        botService.bot.close()
    }

    override fun isRunning(): Boolean {
        return botService.bot.isOnline
    }
}
