package co.edureka.rest.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/balance").hasAuthority("ADMIN")
		.antMatchers("/statement").hasAuthority("MANAGER")
		.antMatchers("/myloan").hasAuthority("EMPLOYEE")
		.antMatchers("/customercare").hasAnyAuthority("ADMIN","EMPLOYEE")
		
		.anyRequest()
		.authenticated()
		
		.and()
		.formLogin()
		//.defaultSuccessUrl("/home",true)
		
		.and()
		.httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select user_name, user_pwd, user_enabled from user_dtls where user_name=?")
			.authoritiesByUsernameQuery("select user_name, user_role from user_dtls where user_name=?")
			.passwordEncoder(encoder);
	}

}
