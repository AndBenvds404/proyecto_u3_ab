package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.libreria.modelo.Proveedor;
import com.uce.edu.demo.repository.libreria.service.IProveedorService;

@SpringBootApplication
public class ProyectoU3AbApplication implements CommandLineRunner {
	
	Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IProveedorService iProveedorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		LOG.info("INNER JOIN");
		List<Proveedor> listaProveedor = this.iProveedorService.buscarProveedorInnerJoin(10);
		for (Proveedor p: listaProveedor) {
			LOG.info("Proveedores:"+ p);
		}
		
		LOG.info("OUTER  LEFT JOIN");
		List<Proveedor> listaProveedor2 = this.iProveedorService.buscarProveedorOuterJoinLeft(10);
		for (Proveedor p2: listaProveedor2) {
			LOG.info("Proveedores:"+ p2);
		}
		
		LOG.info("OUTER RIGHT JOIN");
		List<Proveedor> listaProveedor3 = this.iProveedorService.buscarProveedorOuterJoinRight(10);
		for (Proveedor p3: listaProveedor3) {
			LOG.info("Proveedores:"+ p3);
		}
		

		
		
		
	}

}
