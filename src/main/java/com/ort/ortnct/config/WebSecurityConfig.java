package com.ort.ortnct.config;

import com.ort.ortnct.entity.View;
import com.ort.ortnct.repository.ViewRepository;
import com.ort.ortnct.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.AntPathRequestMatcherProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
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

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Primary
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }

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
                .antMatchers("/user/{user_id}").permitAll()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                .antMatchers(HttpMethod.POST,"/user").permitAll()
                .antMatchers(HttpMethod.POST,"/subject/ort/final").permitAll()
                .antMatchers(HttpMethod.POST,"/subject/ort/subject").permitAll()
                .antMatchers(HttpMethod.GET,"/eduMaterial").permitAll()
                .antMatchers(HttpMethod.GET,"/eduMaterial/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/eduMaterial").permitAll()
                .antMatchers(HttpMethod.PUT,"/eduMaterial").permitAll()
                .antMatchers(HttpMethod.POST,"/eduMaterial").permitAll()
                .antMatchers(HttpMethod.POST,"/ subjectCreationRequestOFMAP").permitAll()
                        //staff
                .antMatchers(HttpMethod.GET,"/staff").permitAll()
                .antMatchers(HttpMethod.DELETE,"/staff").permitAll()
                .antMatchers(HttpMethod.PUT,"/staff").permitAll()
                .antMatchers(HttpMethod.POST,"/staff").permitAll()
                     //testResults
                .antMatchers(HttpMethod.GET,"/testResult").permitAll()
                .antMatchers(HttpMethod.DELETE,"/testResult").permitAll()
                .antMatchers(HttpMethod.PUT,"/testResult").permitAll()
                .antMatchers(HttpMethod.POST,"/testResult").permitAll()
                    //subject
                .antMatchers(HttpMethod.GET,"/subjectListOrtBasic").permitAll()
                .antMatchers(HttpMethod.GET,"/subjectListOrtAdd").permitAll()
                .antMatchers(HttpMethod.GET,"/subjectListOrtSubjects").permitAll()
                .antMatchers(HttpMethod.POST,"/createAns").permitAll()
                      //subject
                .antMatchers(HttpMethod.GET,"/testResultOrt").permitAll()
                .antMatchers(HttpMethod.POST,"/testResultOrt").permitAll()
                .antMatchers(HttpMethod.PUT,"/testResultOrt").permitAll()
                .antMatchers(HttpMethod.DELETE,"/testResultOrt").permitAll()
                         //NCT SUBJECT
                .antMatchers(HttpMethod.POST,"/subject/nct/subject").permitAll()
                .antMatchers(HttpMethod.GET,"subjectListNctSubjects11").permitAll()
                .antMatchers(HttpMethod.GET,"subjectListNctSubjects5").permitAll()
                .antMatchers(HttpMethod.GET,"subjectListNctSubjects6").permitAll()
                .antMatchers(HttpMethod.GET,"subjectListNctSubjects7").permitAll()
                .antMatchers(HttpMethod.GET,"subjectListNctSubjects8").permitAll()
                .antMatchers(HttpMethod.GET,"subjectListNctSubjects9").permitAll()
                .antMatchers(HttpMethod.GET,"subjectListNctSubjects10").permitAll();


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
