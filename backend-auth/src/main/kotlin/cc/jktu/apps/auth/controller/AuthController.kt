package cc.jktu.apps.auth.controller

import cc.jktu.apps.auth.controller.req.LoginReq
import cc.jktu.apps.auth.controller.req.UserAddOrUpdateReq
import cc.jktu.apps.auth.service.UserService
import cc.jktu.apps.common.CommonResp
import cc.jktu.apps.common.emptyRespWithMsg
import cc.jktu.apps.common.exception.BadRequestException
import cc.jktu.apps.common.util.BcryptUtil
import cn.dev33.satoken.stp.StpUtil
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
@Tag(name = "认证接口")
class AuthController(
    private val userService: UserService
) {

    @Operation(summary = "登录")
    @PostMapping("/login")
    fun login(@RequestBody req: LoginReq): CommonResp<Nothing?> {
        val username = req.username
        val password = req.password
        val user = userService.getByUsername(username)
        val ret = BcryptUtil.checkPassword(password, user.password ?: "")
        if (!ret) {
            throw BadRequestException("密码错误")
        }
        StpUtil.login(user.id)
        return emptyRespWithMsg("登陆成功")
    }

    @Operation(summary = "注册")
    @PostMapping("/register")
    fun addOne(@RequestBody req: UserAddOrUpdateReq): CommonResp<Nothing?> {
        userService.addOne(req.username, req.password)
        return emptyRespWithMsg("注册成功")
    }
}
