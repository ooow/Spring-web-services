package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import service.MyUserDetailsService;


/**
 * Created by Гога on 11.04.2016.
 */
/*@Configuration
@EnableWebSecurity*/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!22222");
        http

                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        *//*DirResourceSet
                getResource*//*
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!33333");
        auth
                .userDetailsService(new MyUserDetailsService());
    }*/
}

/*
<security:authentication-manager>
<security:authentication-provider>
<security:user-service>
<security:user name="jimi" password="q" authorities="ROLE_USER, ROLE_ADMIN" />
<security:user name="bob" password="bobspassword" authorities="ROLE_USER" />
</security:user-service>
</security:authentication-provider>
</security:authentication-manager>*/
