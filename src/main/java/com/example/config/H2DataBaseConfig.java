package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.example.data.PersonDAO;

@Configuration
public class H2DataBaseConfig {

	@Bean
	public DataSource dataSource() {
		
		return new EmbeddedDatabaseBuilder()
				.generateUniqueName(false)
				.setName("testdb")
				.setType(EmbeddedDatabaseType.H2)
				.addScripts("schema.sql", "data.sql")
				.setScriptEncoding("UTF-8")
				.ignoreFailedDrops(true)
				.build();
		
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		System.out.println("%%%%%%%%%%%%%%%%%%% dataSource(): " + dataSource().getClass());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
		return namedParameterJdbcTemplate;
		
	}
	
	@Bean
	public PersonDAO personDAO() {
		return new PersonDAO();
	}
	
}
