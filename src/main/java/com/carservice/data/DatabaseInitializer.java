package com.carservice.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

@Component
public class DatabaseInitializer implements CommandLineRunner {

	private final DataSource dataSource;

	public DatabaseInitializer(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void run(String... args) throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			DatabaseMetaData metaData = connection.getMetaData();
			ResultSet tables = metaData.getTables(null, null, "%", null);
			if (!tables.next()) {
				// No tables exist, so the database is not initialized
				ScriptUtils.executeSqlScript(connection, new ClassPathResource("data.sql"));
			}
		}
	}
}