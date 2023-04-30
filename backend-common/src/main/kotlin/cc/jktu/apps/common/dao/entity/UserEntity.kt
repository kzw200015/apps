package cc.jktu.apps.common.dao.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.fasterxml.jackson.annotation.JsonIgnore

@TableName("user")
data class UserEntity(
    var username: String? = null,
    @JsonIgnore
    var password: String? = null
) : BaseEntity()
