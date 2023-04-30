package cc.jktu.apps.gateway.auth

import cn.dev33.satoken.stp.StpInterface
import org.springframework.stereotype.Component

@Component
class StpInterfaceImpl : StpInterface {

    override fun getPermissionList(loginId: Any, loginType: String): List<String> {
        return listOf()
    }

    override fun getRoleList(loginId: Any, loginType: String): List<String> {
        return listOf()
    }
}