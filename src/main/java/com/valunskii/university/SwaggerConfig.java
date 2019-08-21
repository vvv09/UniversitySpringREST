package com.valunskii.university;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final static Logger logger = LogManager.getLogger(SwaggerConfig.class);

    private static String authServer;
    private static String clientId;
    private static String clientSecret;

    @PostConstruct
    public void initIt() {

//        authServer ="http://gm-qa.c-i-p.ru/as";
        //authServer ="http://192.168.40.138:5555/as";
        authServer = "http://192.168.40.150:5555/as";

        clientId = "client1";
        clientSecret = "client1";

        logger.info("authServer=" + authServer + " clientId=" + clientId);
    }

    @Bean
    public Docket api() {

        Set<String> produces = new LinkedHashSet<>();
//        produces.add(MediaTypes.HAL_JSON_VALUE);

        Set<String> protocols = new TreeSet<>();
        protocols.add("http");

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("/api/v1")
                .protocols(protocols)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.valunskii.university.controller.rest"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Arrays.asList(securityScheme()))
                .securityContexts(Arrays.asList(securityContext()))
                .produces(produces)
                .ignoredParameterTypes(Date.class)
                .directModelSubstitute(Date.class, String.class)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Swagger для SpringUniversityREST",
                "Здесь представлен список всех REST API, используемых на проекте SpringUniversityREST",
                "1",
                "vvv09.github.io",
                new Contact("Vadim Valunskii", "vvv09.github.io", "dvvv09@gmail.com"),
                "License of API", "http://c-i-p.ru", Collections.emptyList());
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .scopeSeparator(" ")
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }

    private SecurityScheme securityScheme() {
        GrantType grantType = new AuthorizationCodeGrantBuilder()
                .tokenEndpoint(new TokenEndpoint(authServer + "/oauth/token", "oauth_token"))
                .tokenRequestEndpoint(new TokenRequestEndpoint(authServer + "/oauth/authorize", clientId, clientSecret))
                .build();

        return new OAuthBuilder().name("oauth2").grantTypes(Arrays.asList(grantType)).scopes(Arrays.asList(scopes())).build();
    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("READ", "for read operations"),
                new AuthorizationScope("WRITE", "for write operations")
        };
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(
                        Arrays.asList(new SecurityReference("oauth2", scopes())))
                .forPaths(PathSelectors.regex("(?!/test-status).+"))
                .build();
    }
}
