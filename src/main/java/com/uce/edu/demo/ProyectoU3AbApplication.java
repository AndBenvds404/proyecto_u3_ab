package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3AbApplication implements CommandLineRunner {
	
	Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IHotelService iHotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	
		
//		LOG.info("Relacionamiento WHERE");
//		List<Hotel> listaHotelesJoinWhere = this.iHotelService.buscarHotelJoinWhere("familiar");
//		for (Hotel h: listaHotelesJoinWhere) {
//			LOG.info("Hotel Inner Join:"+ h.getNombre()+ " " +h.getDireccion());
//		}
		
		
		LOG.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHoteles2 = this.iHotelService.buscarHotelInnerJoin("familiar");
		for (Hotel h: listaHoteles2) {
			LOG.info("Hotel2:"+ h.getNombre()+ " " +h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				LOG.info("Hotel2 Habitaciones:"+ha);
			}
			
		}
		
		
		LOG.info("Join Fetch");
		List<Hotel> listaHoteles3 = this.iHotelService.buscarHotelJoinFetch("familiar");
		for (Hotel h: listaHoteles3) {
			LOG.info("Hotel3:"+ h.getNombre()+ " " +h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				LOG.info("Hotel3 Habitaciones:"+ ha);
			}
			

		}
		
		
	
		
		
		
		
		
		
	}

}
