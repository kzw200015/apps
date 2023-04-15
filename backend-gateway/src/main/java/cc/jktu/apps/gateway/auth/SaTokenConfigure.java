package cc.jktu.apps.gateway.auth;

import cc.jktu.apps.common.CommonResp;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class SaTokenConfigure {

    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                .addInclude("/**")
                .addExclude("/auth/login")
                .addExclude("/auth/register")
                .addExclude("/swagger-ui/**")
                .addExclude("/*/v3/api-docs/**")
                .addExclude("/swagger-resources/**")
                .addExclude("/new-bing-api-service/**")
                .setAuth(obj -> {
                    SaRouter.match("/**", r -> StpUtil.checkLogin());
                })
                .setError(e -> CommonResp.of(HttpStatus.BAD_REQUEST, null, e.getMessage()));
    }

}