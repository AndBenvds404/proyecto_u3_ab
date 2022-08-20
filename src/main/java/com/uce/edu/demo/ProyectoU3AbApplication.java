package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3AbApplication implements CommandLineRunner {
	
	Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
				
		
		this.iTransferenciaService.realizarTransferencia("00021", "54321", "12345", new BigDecimal(1));



	}
}
