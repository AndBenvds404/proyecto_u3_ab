package com.uce.edu.demo.service.tfuncional;

@FunctionalInterface
public interface IEstudianteConsumer <T>{
	
	public void accept (T arg1 );
}
