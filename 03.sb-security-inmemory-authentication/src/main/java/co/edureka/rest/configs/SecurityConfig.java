package co.edureka.rest.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/home","/customercare").permitAll()
		.antMatchers("/balance","/statement","/myloan").authenticated()
		
		.and()
		.formLogin()
		
		.and()
		.httpBasic();
	}
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin@123").authorities("admin")
			.and()
			.withUser("sunil").password("sunil@123").authorities("read")
			.and()
			.withUser("sanjay").password("sanjay@123").authorities("read")
			.and()
			.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password(getEncoder().encode("admin@123")).authorities("admin")
			.and()
			.withUser("sunil").password(getEncoder().encode("sunil@123")).authorities("read")
			.and()
			.withUser("sanjay").password(getEncoder().encode("sanjay@123")).authorities("read");
	}
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

}
