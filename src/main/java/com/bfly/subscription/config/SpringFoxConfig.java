package com.bfly.subscription.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ClientCredentialsGrant;
import springfox.documentation.service.Response;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	@Value("${auth.url}")
	private String authUrl;
	@Value("${app.name}")
	private String title;

	@Bean
	public Docket WigoMonitoringApiLocal_v_1_1() {

		List<Response> list = getGlobalResponse();

		String desc = title + " API";
		ApiInfo apiinfo = new ApiInfoBuilder()
				.title(title)
				.description(desc)
				.build();

		return new Docket(DocumentationType.OAS_30)
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(oauthClientCredentialsLocal()))
				.apiInfo(apiinfo)
				.useDefaultResponseMessages(false)
				.select()
				// .apis(RequestHandlerSelectors.basePackage("com.bflysoft.wigo.*"))
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build()
				.globalResponses(HttpMethod.GET, list)
				.globalResponses(HttpMethod.PUT, list)
				.globalResponses(HttpMethod.POST, list)
				.globalResponses(HttpMethod.DELETE, list);

	}

	private List<Response> getGlobalResponse() {
		List<Response> list = new ArrayList<Response>();
		list.add(new ResponseBuilder().code("400").description("Bad Request").build());
		list.add(new ResponseBuilder().code("401").description("Unauthorized").build());
		list.add(new ResponseBuilder().code("403").description("Forbidden").build());
		list.add(new ResponseBuilder().code("404").description("Not found").build());
		list.add(new ResponseBuilder().code("500").description("Server Error").build());

		return list;
	}

	@Bean
	SecurityScheme oauthClientCredentialsLocal() {
		return new OAuthBuilder()
				.name("oauth2")
				.grantTypes(Arrays.asList(new ClientCredentialsGrant(authUrl)))
				.scopes(Arrays.asList(scopes()))
				.build();
	}

	@Bean
	SecurityContext securityContext() {
		final SecurityReference securityReference = SecurityReference.builder().reference("oauth2").scopes(scopes())
				.build();
		return SecurityContext.builder().securityReferences(Arrays.asList(securityReference))
				.build();
	}

	private AuthorizationScope[] scopes() {
		return new AuthorizationScope[] { new AuthorizationScope("bflysoftMSA", "bfly7714") };
	}
}