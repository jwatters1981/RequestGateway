package org.boynesoftware;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class App {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(App.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
	
	@Bean
	public MessageConverter messageConverter() {
		JsonMessageConverter jsonMessageConverter = new JsonMessageConverter();
		jsonMessageConverter.setClassMapper(typeMapper());
		return jsonMessageConverter;
	}
	
	@Bean
	public DefaultClassMapper typeMapper() {
		DefaultClassMapper typeMapper = new DefaultClassMapper();
		Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
		idClassMapping.put("bean ",
				org.boynesoftware.requestprocessor.Bean.class);
		typeMapper.setIdClassMapping(idClassMapping);
		return typeMapper;
	}
}
