package cc.jktu.apps.sub.controller

import cc.jktu.apps.sub.config.SubConfig
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletResponse
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
    fun clash(
        @RequestParam target: Target,
        @RequestParam name: String,
        @RequestParam url: String,
        @RequestParam filter: String,
        response: HttpServletResponse,
        model: Model
    ): String {
        val nodeListUrl = UriComponentsBuilder.fromUriString(subConfig.apiUrl).path("/sub")
            .queryParam("target", target.name.lowercase())
            .queryParam("url", URLEncoder.encode(url, Charsets.UTF_8))
            .queryParam("udp", "true")
            .queryParam("list", "true")
            .build()
            .toString()

        model.addAllAttributes(
            mapOf(
                "name" to name,
                "nodeListUrl" to nodeListUrl,
                "filter" to filter
            )
        )
        return when (target) {
            Target.Clash -> "clash.yml"
            Target.Loon -> "loon.conf"
        }
    }
}


enum class Target {
    Clash, Loon
}