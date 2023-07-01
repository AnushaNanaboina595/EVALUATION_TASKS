package com.dextrus_springboot_tasks.controller;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dextrus_springboot_tasks.entity.ConnectionProperties;
import com.dextrus_springboot_tasks.service.ConnectionService;

@RestController
@RequestMapping("/dextrus")
public class ConnectionController {

	@Autowired
	private ConnectionService service;
	
	@PostMapping("/connect")
	public ResponseEntity<String> connectToSqlServer(@RequestBody ConnectionProperties properties){
		Connection connection=service.getSQLServerConnection(properties);
		if(connection==null)
			return new ResponseEntity<String>("Connection Failed", HttpStatus.SERVICE_UNAVAILABLE);
		else
			return new ResponseEntity<String>("Connected to SQL Server", HttpStatus.OK);
	}
	
}
