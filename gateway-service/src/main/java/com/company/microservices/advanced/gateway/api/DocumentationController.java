package com.company.microservices.advanced.gateway.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {

	// v2/api-docs e' la versione di swagger
	// non confondere con v1

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("item-service", "/v1/item-api/v2/api-docs", "2.0"));
		resources.add(swaggerResource("customer-service", "/v1/customer-api/v2/api-docs", "2.0"));
		resources.add(swaggerResource("order-service", "/v1/order-api/v2/api-docs", "2.0"));
		resources.add(swaggerResource("tax-service", "/v1/tax-api/v2/api-docs", "2.0"));
		resources.add(swaggerResource("authentication-service", "/v1/authentication-api/v2/api-docs", "2.0"));
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);

		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
