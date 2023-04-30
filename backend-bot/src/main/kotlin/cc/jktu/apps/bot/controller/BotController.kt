package cc.jktu.apps.bot.controller

import cc.jktu.apps.bot.service.BotService
import cc.jktu.apps.common.CommonResp
import cc.jktu.apps.common.emptyResp
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bot")
class BotController(private val botService: BotService) {

    @PostMapping("/reLogin")
    fun reLogin(): CommonResp<Nothing?> {
        runBlocking { botService.bot.login() }
        return emptyResp()
    }
}
