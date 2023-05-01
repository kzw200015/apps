package cc.jktu.apps.gateway

import cc.jktu.apps.common.CommonResp
import cc.jktu.apps.common.util.toJsonString
import cn.dev33.satoken.reactor.filter.SaReactorFilter
import cn.dev33.satoken.router.SaRouter
import cn.dev33.satoken.stp.StpInterface
import cn.dev33.satoken.stp.StpUtil
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
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

@Configuration
class SaTokenConfig {

    @Bean
    fun saReactorFilter(): SaReactorFilter {
        return SaReactorFilter()
            .addInclude("/**")
            .addExclude("/auth/login")
            .addExclude("/auth/register")
            .addExclude("/swagger-ui/**")
            .addExclude("/swagger-ui.html")
            .addExclude("/webjars/**")
            .addExclude("/v3/**")
            .addExclude("/swagger-resources/**")
            .addExclude("/*/v3/api-docs")
            .setAuth {
                SaRouter.match("/**", StpUtil::checkLogin)
            }
            .setError { CommonResp.of(HttpStatus.BAD_REQUEST, null, it.message).toJsonString() }
    }
}