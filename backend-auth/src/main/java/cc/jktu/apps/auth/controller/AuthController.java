package cc.jktu.apps.auth.controller;

import cc.jktu.apps.auth.controller.req.LoginReq;
import cc.jktu.apps.auth.controller.req.UserAddOrUpdateReq;
import cc.jktu.apps.auth.service.UserService;
import cc.jktu.apps.common.CommonResp;
import cc.jktu.apps.common.dao.entity.UserEntity;
import cc.jktu.apps.common.exception.BadRequestException;
import cc.jktu.apps.common.util.BcryptUtil;
import cn.dev33.satoken.stp.StpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Api(tags = "认证接口")
public class AuthController {

    private final UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public CommonResp<Void> login(@RequestBody LoginReq req) {
        final String username = req.getUsername();
        final String password = req.getPassword();

        final UserEntity user = userService.getByUsername(username);
        final Boolean ret = BcryptUtil.checkPassword(password, user.getPassword());
        if (!ret) {
            throw new BadRequestException("密码错误");
        }
        StpUtil.login(user.getId());
        return CommonResp.emptyWithMsg("登录成功");
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public CommonResp<Void> addOne(@RequestBody UserAddOrUpdateReq req) {
        userService.addOne(req.getUsername(), req.getPassword());
        return CommonResp.emptyWithMsg("注册成功");
    }

}
