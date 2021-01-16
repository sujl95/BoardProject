package me.thewing.boardproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ProxyBeanMethodConfiguration {
	@Bean
	InnerClass innerClass() {
		return new InnerClass();
	}

	public static class InnerClass {
		public InnerClass() {
			System.out.println("InnerClass init!");
		}

		public void call() {
			System.out.println("InnerClass call!");
		}
	}
}
