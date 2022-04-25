//package Login;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration 
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfiguration{
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
////	@Bean
////	@Override
////	public AuthenticationManager authenticationManagerBean() {
////		return super.authentication
////	}
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests()
//		.antMatchers("/Auth/*").permitAll()
//		.antMatchers("/usuarios/*").permitAll();
//		/*exceptionHandling().authenticationEntryPoint()
//		.and()*/
//	}
//}