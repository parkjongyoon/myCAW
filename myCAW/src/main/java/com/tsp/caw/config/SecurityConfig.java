package com.tsp.caw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tsp.caw.user.login.LoginFailureHandler;
import com.tsp.caw.user.login.LoginSuccessHandler;
import com.tsp.caw.user.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	private LoginFailureHandler loginFailureHandler;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()
		    .authorizeRequests()
		    .antMatchers("/login", "/register").permitAll() //인증 없이 허용되는 경로
		    .antMatchers("/admin/**").hasRole("ADMIN")
		 	.antMatchers("/**").authenticated() //인증 받아야 접근할 수 있는 경로
		 	  
		 	.and()
		    .formLogin()
		    .loginPage("/login") //login 페이지
		    .loginProcessingUrl("/authenticate")
		    .usernameParameter("username") //로그인 아이디 param명
		    .passwordParameter("password") //로그인 비밀번호 param명
		    .successHandler(loginSuccessHandler) //login 성공후 처리
		    .failureHandler(loginFailureHandler) //login 실패후 처리
		    ;
    }
    
    @Override
	public void configure(WebSecurity web) throws Exception {
    	web.ignoring().antMatchers("/resources/**"); //해당 경로는 spring security가 관여하지 않는다
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth.authenticationProvider(customAuthenticationProvider);
    	
    	//비밀번호 암호화 없이 로그인할때
//		auth.userDetailsService(userService).passwordEncoder(this.noOpPasswordEncoder());
		
		//비밀번호 암호화 해서 로그인할때
//		auth.userDetailsService(userService).passwordEncoder(this.passwordEncoder());
    }	
}