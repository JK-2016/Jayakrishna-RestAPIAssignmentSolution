package com.employeemanagement.security;

import com.employeemanagement.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsServiceImpl();
	    }
	     
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	     
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());


			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			// In-memory authentication, method chaining
			auth.inMemoryAuthentication()
                .withUser("admin").password(encoder.encode("admin")).authorities("ADMIN");
////				.withUser("user").password(encoder.encode("user")).roles("USER");
//					.withUser("admin").password("admin").roles("ADMIN")
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	            .antMatchers("/api/","/api/save","/api/showFormForAdd","/api/403").hasAnyAuthority("USER","ADMIN")
	            .antMatchers("/api/showFormForUpdate","/api/delete","/api/add").hasAuthority("ADMIN")
	            .anyRequest().authenticated()
	            .and()
	            .formLogin().loginProcessingUrl("/login")
//					.successForwardUrl("/api/")
					.permitAll()
//	            .and()
//	            .logout().logoutSuccessUrl("/login").permitAll()
//	            .and()
//	            .exceptionHandling().accessDeniedPage("/api/403")
	            .and()
	            .cors().and().csrf().disable();
	    }
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(new String[]{"/h2-console/**"});
	}

}
