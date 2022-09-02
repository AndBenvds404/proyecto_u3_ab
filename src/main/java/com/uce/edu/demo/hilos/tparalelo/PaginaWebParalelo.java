package com.uce.edu.demo.hilos.tparalelo;

import java.util.List;

public class PaginaWebParalelo {
	 private String servicio;
	    private List<Integer> peticion;

	    public PaginaWebParalelo(String servicio, List<Integer> peticion) {
	        super();
	        this.servicio = servicio;
	        this.peticion = peticion;
	    }
	    
	    
	    
	    @Override
		public String toString() {
			return "PaginaWebParalelo [servicio=" + servicio + ", peticion=" + peticion + "]";
		}



		//set and get
		public String getServicio() {
			return servicio;
		}

		public void setServicio(String servicio) {
			this.servicio = servicio;
		}

		public List<Integer> getPeticion() {
			return peticion;
		}

		public void setPeticion(List<Integer> peticion) {
			this.peticion = peticion;
		}


	    
}