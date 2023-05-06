package cc.jktu.apps.common.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.toFormattedString(): String = format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN))