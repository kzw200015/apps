package cc.jktu.apps.bot.controller;

import cc.jktu.apps.bot.service.BotService;
import cc.jktu.apps.common.CommonResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
public class BotController {

    private final BotService botService;

    public BotController(BotService botService) {
        this.botService = botService;
    }

    @PostMapping("/reLogin")
    public CommonResp<Void> reLogin() {
        botService.getBot().login();
        return CommonResp.empty();
    }

}
