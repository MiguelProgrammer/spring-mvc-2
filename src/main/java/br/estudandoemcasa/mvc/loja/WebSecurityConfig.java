package br.estudandoemcasa.mvc.loja;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		anyRequest().
		authenticated().
		and().
		formLogin(form -> form
				.loginPage("/login")
				.permitAll()
				);
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		/*
		 * withDefaultPasswordEncoder -> Depreciado, o seu uso é apenas didático.
		 * Não é seguro em ambiente de produção.
		 */
		
		/*
		 * Houve excpetion, era necessário inserir algo como {noop} antes da senha
		 */
		 UserDetails user = User.withUsername("root")
	     .password("{noop}41417852")
	     .roles("USER")
	     .build();

		return new InMemoryUserDetailsManager(user);
		
	}
}
