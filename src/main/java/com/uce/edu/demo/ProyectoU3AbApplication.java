package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.libreria.modelo.Producto;
import com.uce.edu.demo.repository.libreria.modelo.Proveedor;
import com.uce.edu.demo.repository.libreria.service.IProveedorService;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;

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
		
		

		
		
		LOG.info("RELACIONAMIENTO WHERE");
		List<Proveedor> listaProveedores = this.iProveedorService.buscarProveedorJoinWhere(10);
		for (Proveedor p: listaProveedores) {
			LOG.info("Proveedor :"+ p.getNombre()+ " " +p.getEmail());
		}
		
		
		LOG.info("Join Fetch");
		List<Proveedor> listaProveedores2 = this.iProveedorService.buscarProveedorJoinFetch(10);
		for (Proveedor p: listaProveedores2) {
			LOG.info("Proveedores:"+ p.getNombre()+ " " +p.getEmail());
			for (Producto pr : p.getProductos()) {
				LOG.info("Proveedor Productos:"+pr);
			}
			
		}

		
		
		
	}

}
