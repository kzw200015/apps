package cc.jktu.apps.common.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

val Any.log: Logger
    get() = LoggerFactory.getLogger(this.javaClass)

fun currentPath() = try {
    (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request.requestURI
} catch (_: IllegalStateException) {
    null
}