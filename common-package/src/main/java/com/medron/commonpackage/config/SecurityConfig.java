package com.medron.commonpackage.config;

import com.medron.commonpackage.security.JwtRoleConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new JwtRoleConverter());

        /*
        Starting from Spring Security 6.1 and Spring Boot 3.1.0 versions,
        the Spring Security framework team recommends using the Lambda DSL style for configuring security for APIs, web paths, etc.
        Consequently, they have deprecated a few methods within the framework.
        These deprecated methods are planned to be removed in Spring Security 7, which is expected to be released in the next 2-3 years.
        This timeframe allows all developers sufficient time for migrating their code.
         */
        http.cors().and().authorizeHttpRequests(request-> {

            try {
                request
                        .requestMatchers("/filter","api/v1/car/check-car-available/**","/api/v1/car/car-feature/**","/payment/pay/**","/api/v1/car/show-state/**","/actuator/**").permitAll()
                        .requestMatchers("/api/v1/car").hasAnyRole("user").anyRequest().authenticated()
                        .and().csrf().disable()
                        .oauth2ResourceServer().jwt().jwtAuthenticationConverter(converter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

//        http.cors().and().authorizeHttpRequests()
//                .requestMatchers("/filter","api/v1/car/check-car-available/**","/api/v1/car/car-feature/**","/payment/pay/**","/api/v1/car/show-state/**")
//                .permitAll()
//                .requestMatchers("/api/v1/car")
//                .hasAnyRole("user")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable()
//                .oauth2ResourceServer()
//                .jwt()
//                .jwtAuthenticationConverter(converter);

        return http.build();
    }
}
