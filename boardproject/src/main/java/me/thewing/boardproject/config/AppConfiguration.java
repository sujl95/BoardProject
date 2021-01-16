package me.thewing.boardproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	private final ProxyBeanMethodConfiguration proxyBeanMethodConfiguration;

	public AppConfiguration(ProxyBeanMethodConfiguration proxyBeanMethodConfiguration) {
		this.proxyBeanMethodConfiguration = proxyBeanMethodConfiguration;
	}

	@Bean
	OtherInnerClass otherInnerClass() {
		return new OtherInnerClass(proxyBeanMethodConfiguration.innerClass());
	}

	public static class OtherInnerClass {
		public OtherInnerClass(ProxyBeanMethodConfiguration.InnerClass innerClass) {
			innerClass.call();
		}
	}
}
