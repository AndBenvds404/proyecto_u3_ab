package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		LOG.info("INNER JOIN");
		List<Hotel> listaHotelesInnerJoin = this.iHotelService.buscarHotelInnerJoin("familiar");
		for (Hotel h: listaHotelesInnerJoin) {
			LOG.info("Hotel Inner Join:"+ h);
		}
//		List<Hotel> listaHotelesInnerJoin2 = this.iHotelService.buscarHotelInnerJoin();
//		for (Hotel h: listaHotelesInnerJoin2) {
//			LOG.info("Hotel Inner Join:"+ h);
//		}
//		
		
//		LOG.info("LEFT JOIN");
//		List<Hotel> listaHotelesIOuterJoinLeft =this.iHotelService.buscarHotelIOuterJoinLeft("familiar");
//		for (Hotel h: listaHotelesIOuterJoinLeft) {
//			LOG.info("Hotel Left:"+ h);
//		}
//		List<Hotel> listaHotelesIOuterJoinLeft2 =this.iHotelService.buscarHotelIOuterJoinLeft();
//		for (Hotel h: listaHotelesIOuterJoinLeft2) {
//			LOG.info("Hotel Left:"+ h);
//		}		
		
		
//		List<Hotel> listaHotelesIOuterJoinRight =this.iHotelService.buscarHotelIOuterJoinRight("familiar");
//		for (Hotel h: listaHotelesIOuterJoinRight) {
//			LOG.info("Hotel Right:"+ h);
//		}
	}

}
