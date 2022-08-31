package com.uce.edu.demo.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStream {

	public static void main(String[] args) {

		 long tiempoInicial = System.currentTimeMillis();
		List<Integer> listaNumerosAlumnos = new ArrayList<>();
		for (int i = 1; i < 5000; i++) {
			listaNumerosAlumnos.add(i);
		}
		//paralelStrem
		//List<String> listaProcesada = listaNumerosAlumnos.Stream().map(numero -> converitIdAlumno(numero)) 
		List<String> listaProcesada = listaNumerosAlumnos.parallelStream().map(numero -> converitIdAlumno(numero))
				.collect(Collectors.toList());

		listaProcesada.forEach(cadena-> System.out.println(cadena));
		long tiempoFinal = System.currentTimeMillis();
        long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
        System.out.println("Tiempo: " + tiempoTranscurrido+"seg");
	}

	
	private static String converitIdAlumno(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "id: " + id.toString();
	}

}
