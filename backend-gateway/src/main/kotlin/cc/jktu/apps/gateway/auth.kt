package cc.jktu.apps.gateway

import cc.jktu.apps.common.exception.wrapAndThrow
import cn.dev33.satoken.exception.SaTokenException
import cn.dev33.satoken.reactor.filter.SaReactorFilter
import cn.dev33.satoken.router.SaRouter
import cn.dev33.satoken.stp.StpInterface
import cn.dev33.satoken.stp.StpUtil
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod
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
    @Order(999)
    fun saReactorFilter(): SaReactorFilter {
        return SaReactorFilter()
            .addInclude("/**")
            .addExclude("/auth-service/login")
            .addExclude("/auth-service/register")
            .addExclude("/swagger-ui.html")
            .addExclude("/webjars/**")
            .addExclude("/*/v3/api-docs")
            .addExclude("/v3/api-docs/*")
            .addExclude("/sub-service/sub")
            .setAuth {
                SaRouter.match("/**") { obj ->
                    obj.notMatchMethod(HttpMethod.OPTIONS.name()).check { _ ->
                        StpUtil.checkLogin()
                    }
                }
            }
            .setError {
                if (it is SaTokenException) {
                    it.wrapAndThrow()
                }
            }
    }
}