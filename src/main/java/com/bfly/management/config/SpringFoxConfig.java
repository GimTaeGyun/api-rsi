package com.bfly.management.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.LoginEndpointBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ImplicitGrant;
import springfox.documentation.service.LoginEndpoint;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.Response;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Primary
@SuppressWarnings("unchecked")
public class SpringFoxConfig {

	@Value("${keycloak.auth-server-url}")
    private String authServerUrl;
  
    @Value("${keycloak.realm}")
    private String realm;
  
    @Value("${keycloak.resource}")
    private String clientId;
  
    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    @Value("${customvalues.keycloak.adminId}")
    private String adminId;

    @Value("${customvalues.keycloak.adminPw}")
    private String adminPw;

    @Value("${customvalues.keycloak.tokenUrl}")
    private String tokenUrl;

	@Value("${customvalues.keycloak.authUrl}")
    private String authUrl;
	
	@Bean
	public Docket CreateDocketContract() {

		List<Response> list = getGlobalResponse();
		String title = "ContractManagement";

		String desc = title + " API";
		ApiInfo apiinfo = new ApiInfoBuilder()
				.title(title)
				.description(desc)
				.build();

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(title)
				.securitySchemes(buildSecurityScheme())
				.securityContexts(Arrays.asList(securityContext()))
				.apiInfo(apiinfo)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bfly.management.contractmanagement.controller"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.globalResponses(HttpMethod.GET, list)
				.globalResponses(HttpMethod.PUT, list)
				.globalResponses(HttpMethod.POST, list)
				.globalResponses(HttpMethod.DELETE, list);

	}

	@Bean
	public Docket CreateDocketCustomer() {

		List<Response> list = getGlobalResponse();
		String title = "CustomerManagement";

		String desc = title + " API";
		ApiInfo apiinfo = new ApiInfoBuilder()
				.title(title)
				.description(desc)
				.build();

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(title)
				.securitySchemes(buildSecurityScheme())
				.securityContexts(Arrays.asList(securityContext()))
				.apiInfo(apiinfo)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bfly.management.customermanagement.controller"))
				.build()
				.globalResponses(HttpMethod.GET, list)
				.globalResponses(HttpMethod.PUT, list)
				.globalResponses(HttpMethod.POST, list)
				.globalResponses(HttpMethod.DELETE, list);

	}

	@Bean
	public Docket CreateDocketProduct() {

		List<Response> list = getGlobalResponse();
		String title = "ProductManagement";

		String desc = title + " API";
		ApiInfo apiinfo = new ApiInfoBuilder()
				.title(title)
				.description(desc)
				.build();

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(title)
				.apiInfo(apiinfo)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bfly.management.productmanagement.controller"))
				.build()
				.securitySchemes(buildSecurityScheme()).
				securityContexts(Arrays.asList(securityContext()))
				.globalResponses(HttpMethod.GET, list)
				.globalResponses(HttpMethod.PUT, list)
				.globalResponses(HttpMethod.POST, list)
				.globalResponses(HttpMethod.DELETE, list);

	}

	@Bean
	public Docket CreateDocketKeycloak() {

		List<Response> list = getGlobalResponse();
		String title = "SecurityManagement";

		String desc = title + " API";
		ApiInfo apiinfo = new ApiInfoBuilder()
				.title(title)
				.description(desc)
				.build();

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(title)
				.apiInfo(apiinfo)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bfly.management.keycloakmanagement.controller"))
				.build()
				.securitySchemes(buildSecurityScheme())
				.securityContexts(Arrays.asList(securityContext()))
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
		GrantType grantType =
                new AuthorizationCodeGrantBuilder()
                        .tokenEndpoint(new TokenEndpoint(String.format(tokenUrl, realm), "swagger-dev"))
                        .tokenRequestEndpoint(
                                new TokenRequestEndpoint(String.format(authUrl, realm), clientId, clientSecret))
                        .build();
        SecurityScheme oauth =
                new OAuthBuilder()
                        .name("spring_oauth")
                        .grantTypes(Arrays.asList(grantType))
                        .build();
        return oauth;
	}

	List<SecurityScheme> buildSecurityScheme(){
		ArrayList<SecurityScheme> lst = new ArrayList<SecurityScheme>();

		LoginEndpoint login = new LoginEndpointBuilder().url(String.format(authUrl, realm)).build();
		ArrayList<GrantType> gTypes = new ArrayList<GrantType>();
		gTypes.add(new ImplicitGrant(login, "access_token"));
		lst.add(new OAuth("oauth2", Arrays.asList(scopes()), gTypes));

		return lst;
	}

	@Bean
	SecurityContext securityContext() {
		final SecurityReference securityReference = SecurityReference.builder().reference("oauth2").scopes(scopes())
				.build();
		return SecurityContext.builder().securityReferences(Arrays.asList(securityReference)).build();
	}

	private AuthorizationScope[] scopes() {
		return new AuthorizationScope[] { 
		};
	}
}