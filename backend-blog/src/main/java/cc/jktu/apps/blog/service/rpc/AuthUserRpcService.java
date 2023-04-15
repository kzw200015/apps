package cc.jktu.apps.blog.service.rpc;

import cc.jktu.apps.common.CommonResp;
import cc.jktu.apps.common.dao.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(value = "auth-service", path = "/users")
public interface AuthUserRpcService {

    @GetMapping("")
    CommonResp<List<UserEntity>> getAllUsers();

    @GetMapping("/{id}")
    CommonResp<UserEntity> getById(@PathVariable Long id);

}
