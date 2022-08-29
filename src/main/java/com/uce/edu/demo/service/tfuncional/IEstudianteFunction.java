package com.uce.edu.demo.service.tfuncional;

@FunctionalInterface
public interface IEstudianteFunction <R, T> {

	R aplicar (T arg1);
}
