package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

import org.springframework.transaction.support.TransactionSynchronizationManager;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	
	Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo =: datoTipoHabitacion",Hotel.class); // h.la relacion mapeada del modelo
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h: hoteles) {
			h.getHabitaciones().size();
		}
		return hoteles;
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha ",Hotel.class); // h.la relacion mapeada del modelo
		return myQuery.getResultList();
	}
	

	@Override
	public List<Hotel> buscarHotelIOuterJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",Hotel.class); // h.la relacion mapeada del modelo
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelIOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo =: datoTipoHabitacion",Hotel.class); // h.la relacion mapeada del modelo
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelIOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h Right JOIN h.habitaciones ha WHERE ha.tipo =: datoTipoHabitacion",Hotel.class); // h.la relacion mapeada del modelo
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelIOuterJoinLeft() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel and ha.tipo =: datoTipoHabitacion ",Hotel.class); //h=ha.hotel -> h es igual a h.id pero se omite
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}
	
	@Override
//	@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		LOG.info("transaccion actia: "+ TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo =: datoTipoHabitacion",Hotel.class); // h.la relacion mapeada del modelo
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

}
