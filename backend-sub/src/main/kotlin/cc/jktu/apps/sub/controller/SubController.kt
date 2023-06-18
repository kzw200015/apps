package cc.jktu.apps.sub.controller

import cc.jktu.apps.sub.config.SubConfig
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.util.UriComponentsBuilder
import java.net.URLEncoder
import java.util.*

@Controller
@Tag(name = "订阅")
@RequestMapping("/sub")
class SubController(
    private val subConfig: SubConfig
) {
    @GetMapping("", produces = [MediaType.TEXT_PLAIN_VALUE])
    @Operation
    fun clash(@RequestParam target: Target, @RequestParam url: String, filter: String, model: Model): String {
        val uri = UriComponentsBuilder.fromUriString(subConfig.apiUrl).path("/sub")
            .queryParam("target", "clash")
            .queryParam("url", URLEncoder.encode(url, Charsets.UTF_8))
            .queryParam("udp", "true")
            .queryParam("list", "true")
            .toUriString()
        model.addAttribute("url", uri)
        model.addAttribute("filter", filter)
        return when (target) {
            Target.Clash -> "clash.yml"
            Target.Loon -> "loon.conf"
        }
    }
}


enum class Target {
    Clash, Loon
}