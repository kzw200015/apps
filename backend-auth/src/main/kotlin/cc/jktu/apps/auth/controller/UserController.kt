package cc.jktu.apps.auth.controller

import cc.jktu.apps.auth.controller.req.UserAddOrUpdateReq
import cc.jktu.apps.auth.service.UserService
import cc.jktu.apps.common.util.CommonResp
import cc.jktu.apps.common.dao.entity.UserEntity
import cc.jktu.apps.common.util.emptyRespWithMsg
import cc.jktu.apps.common.util.ok
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@Tag(name = "用户接口")
class UserController(
    private val userService: UserService
) {

    @Operation(summary = "获取所有用户")
    @GetMapping("")
    fun getAllUsers(): CommonResp<List<UserEntity>> {
        return userService.getAllUsers().ok()
    }

    @Operation(summary = "根据ID获取用户")
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): CommonResp<UserEntity> {
        return userService.getUserById(id).ok()
    }

    @Operation(summary = "添加用户")
    @PostMapping("")
    fun createUser(@RequestBody req: UserAddOrUpdateReq): CommonResp<Nothing?> {
        userService.createUser(req.username, req.password)
        return emptyRespWithMsg("添加成功")
    }

    @Operation(summary = "更新用户")
    @PatchMapping("/{id}")
    fun updateUserById(@PathVariable id: Long, @RequestBody req: UserAddOrUpdateReq): CommonResp<Nothing?> {
        userService.updateUserById(id, req.username, req.password)
        return emptyRespWithMsg("添加成功")
    }
}
