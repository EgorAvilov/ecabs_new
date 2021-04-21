/*
package itechart.config;

import com.itechart.dto.UserDto;
import com.itechart.mapper.UserMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.io.IOException;
import java.time.LocalDateTime;

import static com.itechart.constants.Constants.USER_ADD_QUEUE_NAME;
import static com.itechart.constants.Constants.USER_FIND_BY_ID_QUEUE_NAME;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AmqpTemplate template;
    private final UserMapper userMapper;

    @Autowired
    public WebSecurityConfig(AmqpTemplate template, UserMapper userMapper) {
        this.template = template;
        this.userMapper = userMapper;
    }


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

    @Bean
    public PrincipalExtractor principalExtractor() {
        return map -> {
            String id = (String) map.get("sub");
           */
/* User user = userService.findById(id)
                                   .orElseGet(() -> {
                                       User newUser = new User();
                                       newUser.setId(id);
                                       newUser.setName((String) map.get("name"));
                                       newUser.setEmail((String) map.get("email"));
                                       newUser.setGender((String) map.get("gender"));
                                       newUser.setLocale((String) map.get("locale"));
                                       newUser.setUserpic((String) map.get("picture"));
                                       return newUser;
                                   });*//*

            UserDto userDto = null;
            try {
                userDto = (UserDto) template.convertSendAndReceive(USER_FIND_BY_ID_QUEUE_NAME, userMapper.toJSON(id));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (userDto == null) {
                userDto = new UserDto();
                userDto.setId(id);
                userDto.setName((String) map.get("name"));
                userDto.setEmail((String) map.get("email"));
                userDto.setGender((String) map.get("gender"));
                userDto.setLocale((String) map.get("locale"));
                userDto.setUserpic((String) map.get("picture"));
            }
            userDto.setLastVisit(LocalDateTime.now());
            UserDto userDto1=null;
            try {
                 userDto1=(UserDto) template.convertSendAndReceive(USER_ADD_QUEUE_NAME, userMapper.toJSON(userDto));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //  User user1 = userService.create(user);
            System.out.println(userDto1);
            return userDto1;
        };
    }
}*/
