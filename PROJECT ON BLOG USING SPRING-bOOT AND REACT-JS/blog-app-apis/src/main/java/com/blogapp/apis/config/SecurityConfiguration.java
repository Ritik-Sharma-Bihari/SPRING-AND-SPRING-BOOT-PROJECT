package com.blogapp.apis.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.blogapp.apis.security.CustomUserDetailsService;
import com.blogapp.apis.security.JWT_authenticationEntryPoint;
import com.blogapp.apis.security.JwtAuthenticationEntryPoint;
import com.blogapp.apis.security.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	 @Autowired
	    private JwtAuthenticationEntryPoint point;
	    
	    @Autowired
	    private JwtAuthenticationFilter filter;
	    
	    @Autowired
	    private UserDetailsService  userDetailsService;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http.csrf(csrf -> csrf.disable())
	                .authorizeRequests().
	                requestMatchers("/home").authenticated().requestMatchers("/api/v1/login").permitAll()
	                .requestMatchers("/api/v1/create-user").permitAll()
	                .anyRequest()
	                .authenticated()
	                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
	    
	    // create a bean class to provides the authentcation with database.
	    
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	    	
	    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	    	daoAuthenticationProvider().setUserDetailsService(userDetailsService);
	    	daoAuthenticationProvider().setPasswordEncoder(passwordEncoder);
	    	return daoAuthenticationProvider();
	    }

}










//-------------------------------------------------------------------------

//@Autowired
//private CustomUserDetailsService customUserDetailsService;
//
//@Autowired
//private JWT_authenticationEntryPoint point;
//@Autowired
//private JwtAuthenticationFilter filter;
//
//@Bean
//public UserDetailsService userDetailsService() {
//	/*
//	 * here User is inbulid spring user not user-defined,
//	 *  we are create create user and setting there name and password we can create more than one user also
//	 */
//    UserDetails userDetails =  User.builder().username("ritik")
//            .password(passwordEncoder().encode("ritik123")).roles("user").build();
//    
//    UserDetails userDetails2 =  User.builder().username("ankit")
//            .password(passwordEncoder().encode("ankit123")).roles("ADMIN").build();
//    
//    return new InMemoryUserDetailsManager(userDetails,userDetails2);
//}
//
//
//@Bean
//public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//}
//
//@Bean
//public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
//    return builder.getAuthenticationManager();
//}
//
//
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//    http.csrf(csrf -> csrf.disable())
//            .authorizeRequests().
//            requestMatchers("/home").authenticated().requestMatchers("/auth/login").permitAll()
//            .anyRequest()
//            .authenticated()
//            .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//    return http.build();
//
//










