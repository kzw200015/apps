package cc.jktu.apps.common

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.time.LocalDateTime
import java.util.*

data class CommonPage<T>(val pageNum: Long, val pageSize: Long, val count: Long, val items: List<T>)

fun <T> Page<T>.toCommonPage(): CommonPage<T> {
    return CommonPage(current, size, total, records)
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
data class CommonResp<T>(
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") val timestamp: LocalDateTime,
    val status: Int,
    val message: String,
    val path: String?,
    val data: T
) {

    companion object {

        const val DEFAULT_MESSAGE = "No message available"

        fun <T> of(status: HttpStatus, data: T, message: String?): CommonResp<T> {
            var path: String? = null
            try {
                path = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request.requestURI
            } catch (_: IllegalStateException) {

            }
            return CommonResp(LocalDateTime.now(), status.value(), message ?: DEFAULT_MESSAGE, path, data)
        }
    }
}

fun <T> T.ok(): CommonResp<T> {
    return CommonResp.of(HttpStatus.OK, this, CommonResp.DEFAULT_MESSAGE)
}

fun emptyResp(): CommonResp<Nothing?> {
    return CommonResp.of(HttpStatus.OK, null, CommonResp.DEFAULT_MESSAGE)
}

fun emptyRespWithMsg(msg: String): CommonResp<Nothing?> {
    return CommonResp.of(HttpStatus.OK, null, msg)
}