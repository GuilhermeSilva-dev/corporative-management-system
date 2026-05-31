package com.example.corporatemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class CorporateManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorporateManagementApplication.class, args);
	}
}

// --- CONFIGURAÇÃO DE SEGURANÇA NO MESMO ARQUIVO ---
@Configuration
@EnableWebSecurity
class SecurityConfig { // Sem o modificador "public" porque só pode haver uma classe pública por arquivo Java

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.anyRequest().permitAll()
				)
				.formLogin(form -> form.disable())
				.httpBasic(basic -> basic.disable());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}