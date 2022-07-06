package com.bfly.management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//     /**
//      * Swagger 보안 정책 Configuration 정의
//      */
//     @Override
//     public void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//             .antMatchers(
//                 // -- Swagger UI v2
//                 "/v2/api-docs",
//                 "/swagger-resources",
//                 "/swagger-resources/**",
//                 "/configuration/ui",
//                 "/configuration/security",
//                 "/swagger-ui.html",
//                 "/webjars/**"
//                 // -- Swagger UI v3 (OpenAPI)
//                 // "/v3/api-docs/**",
//                 // "/swagger-ui/**",
//                 // other public endpoints of your API may be appended to this array
//                 // "/**"
//                 ).permitAll()
//             .and()
//             .authorizeRequests()
//             .anyRequest()
//             .authenticated()
//             .and()
//             .csrf().disable();
//     }
// }