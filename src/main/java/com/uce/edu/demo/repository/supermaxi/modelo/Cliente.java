package com.uce.edu.demo.repository.supermaxi.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@Column(name = "clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_id_seq")
    @SequenceGenerator(name = "clie_id_seq", sequenceName = "clie_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "clie_numero_tarjeta")
	private String numeroTarjeta;
	
	@Column(name = "clie_cedula")
	private String cedula;
	

	@OneToMany (mappedBy = "cliente")
	private List<Factura> facturas;
	
	//SET AND GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	
	

}
