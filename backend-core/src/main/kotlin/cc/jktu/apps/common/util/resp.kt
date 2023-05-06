package cc.jktu.apps.common.util

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime
import java.util.*

const val DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss"

data class CommonPage<T>(val pageNum: Long, val pageSize: Long, val count: Long, val items: List<T>)

fun <T> Page<T>.toCommonPage(): CommonPage<T> {
    return CommonPage(current, size, total, records)
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
data class CommonResp<T>(
    @JsonFormat(pattern = DATE_TIME_PATTERN)
    @Schema(format = DATE_TIME_PATTERN)
    val timestamp: String,
    val status: Int,
    val message: String,
    val path: String?,
    val data: T
) {

    companion object {

        const val DEFAULT_MESSAGE = "No message available"

        fun <T> of(status: HttpStatus, data: T, message: String?): CommonResp<T> = CommonResp(
            LocalDateTime.now().toFormattedString(),
            status.value(),
            message ?: DEFAULT_MESSAGE,
            currentPath(),
            data
        )
    }
}

fun <T> T.ok() = CommonResp.of(HttpStatus.OK, this, CommonResp.DEFAULT_MESSAGE)

fun emptyResp() = CommonResp.of(HttpStatus.OK, null, CommonResp.DEFAULT_MESSAGE)

fun emptyRespWithMsg(msg: String) = CommonResp.of(HttpStatus.OK, null, msg)

class CustomErrorAttributes(@Value("\${spring.application.name}") private val applicationName: String) :
    DefaultErrorAttributes() {

    override fun getErrorAttributes(webRequest: WebRequest?, options: ErrorAttributeOptions?): MutableMap<String, Any> =
        super.getErrorAttributes(webRequest, options).apply {
            this["path"] = "/$applicationName${this["path"]}"
        }
}