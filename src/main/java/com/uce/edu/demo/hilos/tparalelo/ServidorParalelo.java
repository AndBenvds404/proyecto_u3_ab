package com.uce.edu.demo.hilos.tparalelo;

import java.util.concurrent.TimeUnit;

public class ServidorParalelo extends Thread{
	
	private PaginaWebParalelo paginaWebParalelo;
	
	public ServidorParalelo(PaginaWebParalelo paginaWebParalelo) {
		// TODO Auto-generated constructor stub
		this.paginaWebParalelo= paginaWebParalelo;
	}
	
	//siempre q se extienda de Thread se debe 
	//sobreescribir el metodo run, dispara el metodo paralelizar
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.procesar(this.paginaWebParalelo);
	}
	
	public void procesar(PaginaWebParalelo paginaWebParalelo) {
		  long to = System.currentTimeMillis();
		System.out.println("Nombre de hilo Processar"+ Thread.currentThread().getName());
		System.out.println("procesando peticion "+ paginaWebParalelo);
		for (Integer peticion: paginaWebParalelo.getPeticion()) {
			this.atenderPeticion(peticion);
		}
	     long tf = System.currentTimeMillis();
	      long dt = (tf-to)/1000;
		System.out.println("termino: "+ paginaWebParalelo.getPeticion()+ "en: "+ dt);
	}
	
	
	private void atenderPeticion(Integer peticion) {
        System.out.println("Atendiendo peticion numero :"+ peticion);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
