package com.ort.ortnct.config;

import com.ort.ortnct.entity.View;
import com.ort.ortnct.repository.ViewRepository;
import com.ort.ortnct.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.AntPathRequestMatcherProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    StaffService staffService;

    @Autowired
    ViewRepository viewRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(staffService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                 http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/getUser/{user_id}").permitAll()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                .antMatchers(HttpMethod.POST,"/createUser").permitAll()
                .antMatchers(HttpMethod.POST,"/subject/ort/final").permitAll()
                .antMatchers(HttpMethod.GET,"/eduMaterial").permitAll()
                .antMatchers(HttpMethod.DELETE,"/eduMaterial").permitAll()
                .antMatchers(HttpMethod.PUT,"/eduMaterial").permitAll();


        List<View> views = viewRepository.findAll();

        for (View v : views)
        {
            List<String> roles = new ArrayList<>();

            v.getRoles().stream().forEach(r -> roles.add(r.getName()));

            HttpMethod method = HttpMethod.valueOf(v.getMethod());
            registry.regexMatchers(method,v.getViewName()).hasAnyRole(roles.toArray(new String[roles.size()]));
            //---------------------------------------
        }

        registry.anyRequest()
                .authenticated()
                .and()
//                .formLogin().loginPage("/login").permitAll()
                .httpBasic()
                .and()
                .sessionManagement()
                .disable();

    }



}
