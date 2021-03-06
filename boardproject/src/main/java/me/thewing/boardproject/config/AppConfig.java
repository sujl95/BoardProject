package me.thewing.boardproject.config;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
public class AppConfig {

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();

		cacheManager.setCaches(Arrays.asList(
				new ConcurrentMapCache("default-keyword"),
				new ConcurrentMapCache("frequent-keyword"),
				new ConcurrentMapCache("trend-keyword"),
				new ConcurrentMapCache("relation-keyword")
		));
		return cacheManager;
	}
}
