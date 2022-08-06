package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	
	@Autowired
	private IHotelRepository iHotelRepository;

	@Override
	
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelIOuterJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelIOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelIOuterJoinLeft(tipoHabitacion);
	}
	@Override
	public List<Hotel> buscarHotelIOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelIOuterJoinLeft();
	}
	

	@Override
	public List<Hotel> buscarHotelIOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelIOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}
	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}
	
	
	
}
