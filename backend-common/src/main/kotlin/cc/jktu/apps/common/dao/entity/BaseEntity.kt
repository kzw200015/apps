package cc.jktu.apps.common.dao.entity

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import lombok.Data

@Data
abstract class BaseEntity(
    @TableId(type = IdType.ASSIGN_ID)
    var id: Long? = null,
    @TableField(fill = FieldFill.INSERT)
    var createTime: Long? = null,
    @TableField(fill = FieldFill.INSERT_UPDATE)
    var updateTime: Long? = null
)
