package lv.venta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Bean
	public UserDetailsManager createTestUser() {
		PasswordEncoder encoder =
			    PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails u1Details = 
				User
				.builder()
				.username("admin")
				.password(encoder.encode("admin"))
				.authorities("ADMIN")
				.build();
		
		UserDetails u2Details = 
				User
				.builder()
				.username("aksels")
				.password(encoder.encode("123"))
				.authorities("USER")
				.build();
		
		return new InMemoryUserDetailsManager(u1Details, u2Details);
		
	}
	
	@Bean
	public SecurityFilterChain configureEndpoints(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/hello").permitAll()
				
				.requestMatchers("/client/filter/all").hasAnyAuthority("USER", "ADMIN")
				.requestMatchers("/client/filter/delete/").hasAuthority("ADMIN")
				.requestMatchers("/client/filter/update").hasAuthority("ADMIN")
				.requestMatchers("/client/filter/create").hasAuthority("ADMIN")
				.requestMatchers("/client/filter/name&surname/").hasAnyAuthority("USER", "ADMIN")
				.requestMatchers("/client/filter/phone/").hasAnyAuthority("USER", "ADMIN")
				.requestMatchers("/mechanic/create").hasAuthority("ADMIN")
				.requestMatchers("/mechanic/show/all").hasAnyAuthority("USER", "ADMIN")
				.requestMatchers("/mechanic/update").hasAuthority("ADMIN")
				.requestMatchers("/mechanic/delete/").hasAuthority("ADMIN")
				.requestMatchers("/mechanic/licenceNo/").hasAuthority("ADMIN")
				.requestMatchers("/mechanic/expLessThan/").hasAnyAuthority("USER", "ADMIN")
				.requestMatchers("/mechanic/expGreaterThan/").hasAnyAuthority("USER", "ADMIN")
				
				.requestMatchers("/tire/filter/all").hasAnyAuthority("USER", "ADMIN")
				.requestMatchers("/tire/filter/price/{threshold}").hasAnyAuthority("USER", "ADMIN")
				.requestMatchers("/tire/filter/manufacturer/{manufacturer}").hasAnyAuthority("USER", "ADMIN")
				.requestMatchers("/tire/update").hasAnyAuthority("ADMIN")
				);
		
		http.formLogin().permitAll();
		
		
		return http.build();
		
	}
	
	

}
