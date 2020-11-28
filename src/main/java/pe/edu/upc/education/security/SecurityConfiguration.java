package pe.edu.upc.education.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioDetailsService usuarioDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider() );
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/asesores").hasRole("ASESOR")
				.antMatchers("/asesores/cursos-asesor").hasRole("ASESOR")
				.antMatchers("/asesores/perfil-asesor").hasRole("ASESOR")
				.antMatchers("/asesores/editar-perfil-asesor").hasRole("ASESOR")
				.antMatchers("/cursos/crear-curso").hasRole("ASESOR")
				
				
				.antMatchers("/").permitAll()
				.antMatchers("/alumnos").hasRole("ALUMNO")
				.antMatchers("/asesores/cursos-alumno").hasRole("ALUMNO")
				.antMatchers("/asesores/perfil-alumno").hasRole("ALUMNO")
				.antMatchers("/asesores/editar-perfil-alumno").hasRole("ALUMNO")
				.antMatchers("/cursos/buscar-curso").hasRole("ALUMNO")
				.antMatchers("/asesores/buscar-asesor").hasRole("ALUMNO")
				.antMatchers("/cursos/**").authenticated()
				
				
			.and()
			.formLogin()				
				.loginProcessingUrl("/signin")
				.loginPage("/login")	
				.defaultSuccessUrl("/default")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
		 	.logout()
		 		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		 		.logoutSuccessUrl("/");
	}



	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Aqui se crea el vinculo entre el Spring security y: el PasswordEncoder y UsuarioDetailsService
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.usuarioDetailsService);
		return daoAuthenticationProvider;
	}

}
