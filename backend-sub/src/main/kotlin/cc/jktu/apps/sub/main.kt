package cc.jktu.apps.sub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SubApp

fun main(args: Array<String>) {
    runApplication<SubApp>(*args)
}