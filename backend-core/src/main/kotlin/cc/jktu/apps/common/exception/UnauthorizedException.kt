package cc.jktu.apps.common.exception

import cn.dev33.satoken.exception.NotLoginException
import cn.dev33.satoken.exception.SaTokenException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class UnauthorizedException(message: String, cause: Throwable) : RuntimeException(message, cause)

fun SaTokenException.wrapAndThrow(): Nothing = when (this) {
    is NotLoginException -> throw UnauthorizedException(this.localizedMessage, this)
    else -> throw this
}