package cc.jktu.apps.common.util

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

fun Any.toJsonString(): String {
    return jacksonObjectMapper().registerModule(JavaTimeModule()).writeValueAsString(this)
}