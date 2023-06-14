package cc.jktu.apps.auth.controller

import cc.jktu.apps.auth.controller.req.LoginReq
import cc.jktu.apps.auth.controller.req.UserAddOrUpdateReq
import cc.jktu.apps.auth.service.UserService
import cc.jktu.apps.common.exception.BadRequestException
import cc.jktu.apps.common.util.CommonResp
import cc.jktu.apps.common.util.checkPassword
import cc.jktu.apps.common.util.emptyRespWithMsg
import cc.jktu.apps.common.util.ok
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
    fun login(@RequestBody req: LoginReq): CommonResp<TokenInfo> {
        val username = req.username
        val password = req.password
        val user = userService.getByUsername(username)
        val ret = checkPassword(password, user.password ?: "")
        if (!ret) {
            throw BadRequestException("密码错误")
        }
        StpUtil.login(user.id)
        val tokenInfo = StpUtil.getTokenInfo()
        return TokenInfo(tokenInfo.tokenName, tokenInfo.tokenValue).ok()
    }

    @Operation(summary = "注册")
    @PostMapping("/register")
    fun addOne(@RequestBody req: UserAddOrUpdateReq): CommonResp<Nothing?> {
        userService.createUser(req.username, req.password)
        return emptyRespWithMsg("注册成功")
    }
}

data class TokenInfo(val tokenName: String, val tokenValue: String)