package cc.jktu.apps.common.rpc

import cc.jktu.apps.common.dao.entity.UserEntity
import cc.jktu.apps.common.util.CommonResp
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("auth-service")
interface AuthRpc {

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: Long): CommonResp<UserEntity>
}