package com.greatlearning.StudentDetails.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.StudentDetails.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth .inMemoryAuthentication() .withUser("Deepanshu") .password("deep")
		 * .roles("Admin") .and() .withUser("aman") .password("aman") .roles("User");
		 */

		// using Dao authentication

		auth.authenticationProvider(myAuthProvider());
	}

	public DaoAuthenticationProvider myAuthProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUs());
		daoAuthenticationProvider.setPasswordEncoder(myPw());

		return daoAuthenticationProvider;
	}

	public UserDetailsService myUs() {
		return (new UserDetailsServiceImpl());
	}

	public BCryptPasswordEncoder myPw() {

		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/student", "/student/homepage", "/addNewStudent", "/student/saveStudent")
				.hasAnyAuthority("User", "Admin").antMatchers("/student/updateStudent1", "/student/deleteStudent")
				.hasAuthority("Admin").anyRequest().authenticated().and().formLogin();

	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http .httpBasic() .and() .authorizeHttpRequests()
	 * .antMatchers("/student/homepage").permitAll()
	 * .antMatchers("/student/addNewStudent","/student/saveStudent").hasAnyRole(
	 * "User","Admin") .antMatchers("/student/updateStudent1" ,
	 * "/student/deleteStudent").hasRole("Admin")
	 * 
	 * .anyRequest() .authenticated() .and() .formLogin();
	 * 
	 * }
	 */

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
}
