package cc.jktu.apps.note.dao

import com.baomidou.mybatisplus.annotation.*

@TableName("note")
data class Note(
    @TableId(type = IdType.ASSIGN_ID)
    var id: Long? = null,
    @TableField(fill = FieldFill.INSERT)
    var createTime: Long? = null,
    @TableField(fill = FieldFill.INSERT_UPDATE)
    var updateTime: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var userId: Long? = null
)
