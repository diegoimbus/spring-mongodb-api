package com.co.intrasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * <h1>MongoDb Spring API</h1>
 * API using Spring framework, MongoDb as DataBase
 * <p>
 * This is the Main class to run the project
 *  
 * @author Diego Imbus <dsn.imbus01@gmail.com>
 * @version 1.0
 * @since 2018
 */
@SpringBootApplication
public class FixedAssetsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixedAssetsApiApplication.class, args);
	}
}
