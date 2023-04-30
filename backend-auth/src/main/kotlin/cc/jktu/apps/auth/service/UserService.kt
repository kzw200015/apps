package cc.jktu.apps.auth.service

import cc.jktu.apps.auth.dao.mapper.UserMapper
import cc.jktu.apps.common.dao.entity.UserEntity
import cc.jktu.apps.common.exception.NotFoundException
import cc.jktu.apps.common.util.BcryptUtil
import com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userMapper: UserMapper
) {

    fun getByUsername(username: String): UserEntity {
        return userMapper.selectOne(lambdaQuery<UserEntity>().eq(UserEntity::username, username))
            ?: throw NotFoundException("未找到用户")
    }

    fun addOne(username: String, password: String) {
        val user = UserEntity()
        user.username = username
        user.password = BcryptUtil.hashPassword(password)
        userMapper.insert(user)
    }

    fun getAllUsers(): List<UserEntity> {
        return userMapper.selectList(null)
    }

    fun getById(id: Long?): UserEntity {
        return userMapper.selectById(id) ?: throw NotFoundException("未找到用户")
    }

    fun updateById(id: Long?, username: String?, password: String?) {
        val user = UserEntity()
        user.id = id
        user.username = username
        user.password = password
        userMapper.updateById(user)
    }
}
