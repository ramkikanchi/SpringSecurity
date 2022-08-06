package co.edureka.rest.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		//super.configure(http);
		/*
		//--- default functionality ---
		//http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
		http.authorizeRequests()
			.anyRequest()
			.authenticated();
		http.formLogin();
		http.httpBasic();
		*/
		
		//-- customize the requirement -- /home,/customercare -- no need to have authnetication
		http.authorizeRequests()
		    .antMatchers("/home","/customercare")
		    .permitAll()
			.antMatchers("/balance","/statement","/myloan")
			.authenticated()
			
			.and()
			.formLogin()
			
			.and()
			.httpBasic();
	}

}
