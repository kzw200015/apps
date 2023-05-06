package cc.jktu.apps.common.dao.entity

import com.baomidou.mybatisplus.annotation.*
import com.fasterxml.jackson.annotation.JsonIgnore

@TableName("user")
data class UserEntity(
    @TableId(type = IdType.ASSIGN_ID)
    var id: Long? = null,
    @TableField(fill = FieldFill.INSERT)
    var createTime: Long? = null,
    @TableField(fill = FieldFill.INSERT_UPDATE)
    var updateTime: Long? = null,
    var username: String? = null,
    @JsonIgnore
    var password: String? = null
)