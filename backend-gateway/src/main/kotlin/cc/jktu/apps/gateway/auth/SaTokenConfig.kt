package cc.jktu.apps.gateway.auth

import cc.jktu.apps.common.CommonResp
import cn.dev33.satoken.reactor.filter.SaReactorFilter
import cn.dev33.satoken.router.SaRouter
import cn.dev33.satoken.stp.StpUtil
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus

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
            .setAuth {
                SaRouter.match("/**", StpUtil::checkLogin)
            }
            .setError { e: Throwable -> CommonResp.of(HttpStatus.BAD_REQUEST, null, e.message) }
    }
}