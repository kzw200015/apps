package cc.jktu.apps.common

import com.baomidou.mybatisplus.extension.plugins.pagination.Page

data class CommonPage<T>(val pageNum: Long, val pageSize: Long, val count: Long, val items: List<T>)

fun <T> Page<T>.toCommonPage(): CommonPage<T> {
    return CommonPage(current, size, total, records)
}