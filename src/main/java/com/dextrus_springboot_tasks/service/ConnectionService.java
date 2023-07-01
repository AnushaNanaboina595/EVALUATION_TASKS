package com.dextrus_springboot_tasks.service;

import java.sql.Connection;

import org.springframework.stereotype.Service;

import com.dextrus_springboot_tasks.common.CC;
import com.dextrus_springboot_tasks.entity.ConnectionProperties;

@Service
public class ConnectionService {

	public Connection getSQLServerConnection(ConnectionProperties properties) {
		Connection con=CC.getConnection(properties);
		return con;
	}

}
