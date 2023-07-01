package com.dextrus_springboot_tasks.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.dextrus_springboot_tasks.entity.ConnectionProperties;

public class CC {
  private static Connection connection=null;
  
  public static Connection getConnection(ConnectionProperties properties) {
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connection=DriverManager.getConnection(properties.getUrl(),properties.getUsername(),properties.getPassword());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return connection; 
  }
	
}
