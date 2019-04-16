package ru.shikhovtsev.videoShop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.shikhovtsev.videoShop.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register").anonymous()
                .antMatchers("/login").anonymous()
                .antMatchers("/profile").authenticated()
                .antMatchers("/users").hasRole("ADMIN")
                .antMatchers("/orders").authenticated()
                .antMatchers("/bag").hasRole("USER")
                .antMatchers("/**/admin/**").hasRole("ADMIN");

        http.csrf().disable();

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/spring_security_check")
                //FIXME change to Profile.jsp
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                //For logout page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");
    }
}
