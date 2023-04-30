package cc.jktu.apps.note

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NoteApp

fun main(args: Array<String>) {
    runApplication<NoteApp>(*args)
}