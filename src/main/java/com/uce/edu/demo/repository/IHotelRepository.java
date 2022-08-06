package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {
	
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelInnerJoin( );
	public List<Hotel> buscarHotelIOuterJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelIOuterJoinLeft(String tipoHabitacion);
	public List<Hotel> buscarHotelIOuterJoinLeft( );
	public List<Hotel> buscarHotelIOuterJoinRight(String tipoHabitacion);
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion);	
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);
	
}
