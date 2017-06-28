package com.val.controller.dto;

import java.util.LinkedList;
import java.util.List;

public class Accion {
	
//	private List<String> funciones;
//	private List<List<String>> parametros;

	private String accion;
	private List<String> parametros;
	
	//TODO Mejorar el modelo para que la lista de parámetros sea una lista de una lista
	// y así, poder pasar parámetros, que constituyen en sí una lista
	// No se ha dado la necesidad, luego no se implementa esa necesidad teórica
	
	public Accion (String ... parametros)
	{
		accion = parametros[0];
		
		this.parametros = new LinkedList<String>();
		
		for (int i = 1; i < parametros.length; i ++)
		{
			this.parametros.add(0, parametros[i]);
		}
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public List<String> getParametros() {
		return parametros;
	}

	public void setParametros(List<String> parametros) {
		this.parametros = parametros;
	}
	

}
