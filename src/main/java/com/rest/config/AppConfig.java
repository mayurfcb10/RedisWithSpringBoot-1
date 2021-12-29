package com.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.rest.model.Student;

@Configuration
public class AppConfig {
	
	// 1. Redis Connection 
	@Bean
	public RedisConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory();
	}
	
	// 2. By using Redis Template object we create HashOperation object
	@Bean
	public RedisTemplate<String, Student> redisTemplate() {
		RedisTemplate<String, Student> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory());
		return template;
	} 

}
