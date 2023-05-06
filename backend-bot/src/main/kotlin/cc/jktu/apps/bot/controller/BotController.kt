package cc.jktu.apps.bot.controller

import cc.jktu.apps.bot.service.BotService
import cc.jktu.apps.common.util.CommonResp
import cc.jktu.apps.common.util.emptyResp
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bot")
@Tag(name = "qq机器人接口")
class BotController(private val botService: BotService) {

    @PostMapping("/reLogin")
    @Operation(summary = "重新登陆")
    fun reLogin(): CommonResp<Nothing?> {
        runBlocking { botService.bot.login() }
        return emptyResp()
    }
}
