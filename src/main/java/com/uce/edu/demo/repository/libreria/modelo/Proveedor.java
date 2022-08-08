package com.uce.edu.demo.repository.libreria.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {	
	
	@Id
	@Column(name = "prov_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prov_id_seq") // nombre (original/referencia) del																				// secuencia de la db
	@SequenceGenerator(name = "prov_id_seq", sequenceName = "prov_id_seq", allocationSize = 1) // nombre dela secuecia	
	private Integer id;
	
	@Column(name = "prov_nombre")
	private String nombre;
	@Column(name = "prov_numero_contrato")
	private String numContrato;
	@Column(name = "prov_email")
	private String email;
	
	@OneToMany (mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List <Producto> productos;
	
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", numContrato=" + numContrato + ", email=" + email
				+ ", productos=" + productos + "]";
	}

	
	// SET AND GET
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	
	
	
}
