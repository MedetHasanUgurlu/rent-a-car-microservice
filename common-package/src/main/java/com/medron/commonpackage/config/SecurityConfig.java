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
        var converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new JwtRoleConverter());

        http.cors().and().authorizeHttpRequests()
                .requestMatchers("/filter","api/v1/car/check-car-available/**","/api/v1/car/car-feature/**","/payment/pay/**","/api/v1/car/show-state/**")
                .permitAll()
                .requestMatchers("/api/v1/car")
                .hasAnyRole("user")
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(converter);

        return http.build();
    }
}
