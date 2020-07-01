package br.com.hamburgueria.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("user"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/lanches").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/lanches/*").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/lanches/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/cadastrar").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/h2/*").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable()
                .headers().frameOptions().sameOrigin();
    }

}
