package me.thewing.boardproject;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
// public class H2ServerConfiguration {
// 	// @Bean
// 	// public Server h2TcpServer() throws SQLException {
// 	// 	return Server.createTcpServer().start();
// 	// }
//
// 	@Bean
// 	@ConfigurationProperties("spring.datasource.hikari") // yml의 설정값을 Set한다.
// 	public DataSource dataSource() throws SQLException {
// 		Server.createTcpServer("-tcp", "-tcpAllowOthers", "-ifNotExists", "-tcpPort", "9092").start();
// 		return new com.zaxxer.hikari.HikariDataSource();
// 	}
// }
