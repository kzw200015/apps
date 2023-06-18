package cc.jktu.apps.sub

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class SubException(msg: String?) : RuntimeException(msg)