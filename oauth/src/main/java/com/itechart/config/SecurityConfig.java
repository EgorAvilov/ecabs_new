package com.itechart.config;

import com.itechart.dto.User;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }

    //здесь сделать забор из очереди
    @Bean
    public PrincipalExtractor principalExtractor() {
        return map -> {
            String id = (String) map.get("sub");
            User user = new User();
            user.setId(id);
            user.setName((String) map.get("name"));
            user.setEmail((String) map.get("email"));
            user.setGender((String) map.get("gender"));
            user.setLocale((String) map.get("locale"));
            user.setUserpic((String) map.get("picture"));
            System.out.println(user);
           /* UserDt user = userDetailsRepo.findById(id).orElseGet(() -> {
                User newUser = new User();

                newUser.setId(id);
                newUser.setName((String) map.get("name"));
                newUser.setEmail((String) map.get("email"));
                newUser.setGender((String) map.get("gender"));
                newUser.setLocale((String) map.get("locale"));
                newUser.setUserpic((String) map.get("picture"));

                return newUser;
            });*/

            // user.setLastVisit(LocalDateTime.now());
            return null;
            // return userDetailsRepo.save(user);
        };
    }
}
