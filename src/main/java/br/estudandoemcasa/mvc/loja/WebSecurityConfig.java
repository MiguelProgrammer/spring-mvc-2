package br.estudandoemcasa.mvc.loja;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin(form -> form.loginPage("/login")
		.defaultSuccessUrl("/home", true).permitAll())
		.logout(logout -> logout.logoutUrl("/logout")).csrf().disable();
	}
	
	@Override
<<<<<<< HEAD
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
			/*UserDetails user = 
				User.withUsername("root")
				.password(encoder.encode("41417852"))
				.roles("ADM")
				.build();*/
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder);
		//.withUser(user);
		
=======
	public UserDetailsService userDetailsService() {
		/*
		 * withDefaultPasswordEncoder -> Depreciado, o seu uso é apenas didático. Não é
		 * seguro em ambiente de produção.
		 */

		/*
		 * Houve excpetion, era necessário inserir algo como {noop} antes da senha
		 */
		UserDetails user = User.withUsername("root").password("{noop}").roles("USER").build();
		return new InMemoryUserDetailsManager(user);

>>>>>>> 42cdd861449908d7bfb9b9887b04a0503879d277
	}

}
