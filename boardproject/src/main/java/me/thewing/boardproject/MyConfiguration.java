package me.thewing.boardproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import me.thewing.boardproject.service.TestService;

@Configuration
public class MyConfiguration {
	@Bean(name = "emailerService")
	@Conditional(WindowsCondition.class)
	public TestService windowsEmailerService() {
		System.out.println("ck");
		return new TestService();
	}
}
