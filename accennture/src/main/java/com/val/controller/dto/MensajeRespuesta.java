package com.val.controller.dto;

import java.util.List;

public class MensajeRespuesta {
	
	//private Validacion validacion;
	private List<Accion> accion;
	
	public MensajeRespuesta  (List<Accion> accion)
	{
		//this.validacion = validacion;
		this.accion = accion;
	}
	
	
	public List<Accion> getAccion() {
		return accion;
	}
	public void setAccion(List<Accion> accion) {
		this.accion = accion;
	}

}
