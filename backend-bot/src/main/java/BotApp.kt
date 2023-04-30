package cc.jktu.apps.bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BotApp

fun main(args: Array<String>) {
    runApplication<BotApp>(*args)
}
