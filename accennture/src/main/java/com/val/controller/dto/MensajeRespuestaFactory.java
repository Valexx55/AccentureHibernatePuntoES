package com.val.controller.dto;

import java.util.LinkedList;
import java.util.List;

public class MensajeRespuestaFactory {
	
	
	
	public static MensajeRespuesta crearRespuesta  (Accion ... accions)
	{
		MensajeRespuesta mensaje_respuesta = null;
		
			List<Accion> lista_acciones = new LinkedList<Accion>();
			
			for (Accion accion : accions)
			{
				lista_acciones.add(0, accion);
			}
			
			mensaje_respuesta = new MensajeRespuesta(lista_acciones);
		
		return mensaje_respuesta;
	}
	
}
