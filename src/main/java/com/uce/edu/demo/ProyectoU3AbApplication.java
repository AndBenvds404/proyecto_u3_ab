package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.supermaxi.service.IGestorComprasService;

@SpringBootApplication
public class ProyectoU3AbApplication implements CommandLineRunner {

	@Autowired
	private IGestorComprasService gestorComprasService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<String> codigos = new ArrayList<String>();
		codigos.add("001");
		codigos.add("002");
		
		this.gestorComprasService.registrarCompraProducto("17270", "004", codigos);
		

	}
	
}
