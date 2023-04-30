package cc.jktu.apps.note.dao

import com.baomidou.mybatisplus.annotation.TableName

@TableName("note")
data class Note(
    var id: Long? = null,
    var createTime: Long? = null,
    var updateTime: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var userId: Long? = null
)
