package com.example.spotify.controllers.configuration;

import com.example.spotify.controllers.services.DataUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter {
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 @Autowired
	 private DataUserDetailsService userDetailsService;
	 @Autowired
	 AuthenticationSuccessHandler successHandler;
		
	   @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		   auth.inMemoryAuthentication()
				   .withUser("user").password(bCryptPasswordEncoder.encode("123")).roles("STANDARD")
				   .and()
				   .withUser("admin").password(bCryptPasswordEncoder.encode("admin")).roles("PREMIUM");

			/*
		   auth
				   .userDetailsService(userDetailsService)
				   .passwordEncoder(bCryptPasswordEncoder);*/
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        String loginPage = "/login";
	        String logoutPage = "/logout";

	        http
					.authorizeRequests()
	                .antMatchers("/").permitAll()
	                .antMatchers(loginPage).permitAll()
	                .antMatchers("/registration").permitAll()
	                .antMatchers("/premium/**").hasAuthority("PREMIUM")
	                .antMatchers("/standard/**").hasAuthority("STANDARD")
	                .anyRequest()
	                .authenticated()
	                .and().csrf().disable()
	                .formLogin()
	                //.loginPage(loginPage)
	                //.loginPage("/")
	                .successHandler(successHandler)
	                .failureUrl("/login?error=true") 
	                .usernameParameter("user_name")
	                .passwordParameter("password")
	                .and().logout()
	                .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
	                .logoutSuccessUrl(loginPage).and().exceptionHandling();
	    }

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	                .ignoring()
	                .antMatchers("/static/**");
	    }
}