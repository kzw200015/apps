package cc.jktu.apps.gateway.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;

@Primary
@Configuration
@RequiredArgsConstructor
public class SwaggerGatewayConfig implements SwaggerResourcesProvider {

    private final GatewayProperties gatewayProperties;

    @Override
    public List<SwaggerResource> get() {
        return gatewayProperties.getRoutes().stream().map(route -> {
            final SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setSwaggerVersion("3.0");
            swaggerResource.setName(route.getId());
            swaggerResource.setLocation("/" + route.getId() + "/v3/api-docs");
            return swaggerResource;
        }).toList();
    }

}
