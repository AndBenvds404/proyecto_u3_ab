package com.uce.edu.demo.service.tfuncional;

@FunctionalInterface
public interface IEstudiantePredicate <T>{

	public Boolean evaluar (T arg1);
}
