package pl.drivingschool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSourceApp;

    private final static String userQuery = "SELECT EMAIL,PASSWORD,ACTIVE FROM USER WHERE EMAIL=?";
    private final static String rolesQuery =
            "SELECT U.EMAIL,R.ROLE FROM USER U INNER JOIN USER_ROLE UR ON(U.USER_ID=UR.USER_ID) INNER JOIN ROLE R ON(UR.ROLE_ID=R.ROLE_ID) WHERE U.EMAIL=?";





//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("user")
//                .roles("ADMIN");
//                .dataSource(dataSourceApp)
//                .passwordEncoder(bCryptPasswordEncoder);
//    }
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests().antMatchers("/admin/**")
//                .access("hasRole('ROLE_ADMIN')").and().formLogin()
//                .loginPage("/login").failureUrl("/login?error")
////                .usernameParameter("username")
////                .passwordParameter("password")
//                .and().logout().logoutSuccessUrl("/login?logout")
//                .and().csrf()
//                .and().exceptionHandling().accessDeniedPage("/403");
//    }

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.authenticationProvider(customAuthenticationProvider);
        auth.jdbcAuthentication()
                .dataSource(dataSourceApp)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .passwordEncoder(bCryptPasswordEncoder);
    }

//    @Override
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("user")
//                .roles("ADMIN");
//
//    }
}
