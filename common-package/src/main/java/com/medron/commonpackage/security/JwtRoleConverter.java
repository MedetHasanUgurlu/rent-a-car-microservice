package com.medron.commonpackage.security;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        return extractRoles(source);
    }

    private Collection<GrantedAuthority> extractRoles(Jwt jwt){
        /* <====== JWT Map<String,Object> ======>

        {
            "exp": 1686079863,
                "iat": 1686079563,
                "jti": "896f419b-e926-44b8-81d3-bf54a09a5b52",
                "iss": "http://192.168.1.102:8080/realms/medron",
                "aud": "account",
                "sub": "fdf1cb39-a82c-4d4d-b34b-3a30c5136b2c",
                "typ": "Bearer",
                "azp": "rent-a-car-microservice",
                "session_state": "f68be9d0-ad78-4d2d-ab4c-cbe2a9ee3c92",
                "acr": "1",
                "allowed-origins": [

  ],
            "realm_access": {
            "roles": [
            "offline_access",
                    "admin",
                    "uma_authorization",
                    "default-roles-medron"
    ]
        },
            "resource_access": {
            "account": {
                "roles": [
                "manage-account",
                        "manage-account-links",
                        "view-profile"
      ]
            }
        },
            "scope": "profile",
                "sid": "f68be9d0-ad78-4d2d-ab4c-cbe2a9ee3c92",
                "name": "deneme deneme",
                "preferred_username": "deneme",
                "given_name": "deneme",
                "family_name": "deneme"
        } */
        Map<String,Object> claims = jwt.getClaims();


        /*
        "realm_access": {
            "roles": [
            "offline_access",
                    "admin",
                    "uma_authorization",
                    "default-roles-medron"
                    ]
        }
         */

        Map<String,Object> realmAccess = (Map<String, Object>) claims.getOrDefault("realm_access", Collections.emptyMap());
        /*
        "roles": ["offline_access", "admin", "uma_authorization", "default-roles-medron"]
         */

        List<String> roles = (List<String>) realmAccess.getOrDefault("roles",Collections.emptyMap());
        /*

        List<GrantedAuthority> authorityList = {
        new SimpleGrantedAuthority("ROLE_offline_access"),
        new SimpleGrantedAuthority("ROLE_admin"),
        new SimpleGrantedAuthority("ROLE_uma_authorization"),
        new SimpleGrantedAuthority("ROLE_default-roles-medron")
        }

         */

        return roles.stream().map(s -> new SimpleGrantedAuthority("ROLE_"+ s)).collect(Collectors.toList());


    }
}
