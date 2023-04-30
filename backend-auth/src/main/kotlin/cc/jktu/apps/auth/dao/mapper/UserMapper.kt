package cc.jktu.apps.auth.dao.mapper

import cc.jktu.apps.common.dao.entity.UserEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<UserEntity>
