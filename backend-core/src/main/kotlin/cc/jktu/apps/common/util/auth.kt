package cc.jktu.apps.common.util

import cc.jktu.apps.common.exception.wrapAndThrow
import cn.dev33.satoken.exception.SaTokenException
import cn.dev33.satoken.stp.StpUtil

fun getCurrentUserId(): Long = try {
    StpUtil.getLoginIdAsLong()
} catch (e: SaTokenException) {
    e.wrapAndThrow()
}
