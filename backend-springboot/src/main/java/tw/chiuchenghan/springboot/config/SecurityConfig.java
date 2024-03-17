package tw.chiuchenghan.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    @Bean 
    public PasswordEncoder passwordEncoder() { 
    	//https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt
        return new BCryptPasswordEncoder(); // internally generate a random "salt"
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
	        .authorizeRequests()
		        .antMatchers("/**").permitAll()  // 允许所有请求
		        .and()
		    .csrf().disable();  // 禁用CSRF保护，可选
        return http.build();
    }
}
