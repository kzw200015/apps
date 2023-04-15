package cc.jktu.apps.auth.controller;

import cc.jktu.apps.auth.controller.req.UserAddOrUpdateReq;
import cc.jktu.apps.auth.service.UserService;
import cc.jktu.apps.common.CommonResp;
import cc.jktu.apps.common.dao.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Api(tags = "用户接口")
public class UserController {

    private final UserService userService;

    @ApiOperation("获取所有用户")
    @GetMapping("")
    public CommonResp<List<UserEntity>> getAllUsers() {
        return CommonResp.ok(userService.getAllUsers());
    }

    @ApiOperation("根据ID获取用户")
    @GetMapping("/{id}")
    public CommonResp<UserEntity> getById(@PathVariable Long id) {
        return CommonResp.ok(userService.getById(id));
    }

    @ApiOperation("添加用户")
    @PostMapping("/addOne")
    public CommonResp<Void> addOne(@RequestBody UserAddOrUpdateReq req) {
        userService.addOne(req.getUsername(), req.getPassword());
        return CommonResp.emptyWithMsg("添加成功");
    }

    @ApiOperation("更新用户")
    @PatchMapping("/{id}")
    public CommonResp<Void> updateById(@PathVariable Long id, @RequestBody UserAddOrUpdateReq req) {
        userService.updateById(id, req.getUsername(), req.getPassword());
        return CommonResp.emptyWithMsg("添加成功");
    }

}
