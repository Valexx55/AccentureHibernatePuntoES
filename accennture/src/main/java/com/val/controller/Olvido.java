package com.val.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.val.controller.dto.Accion;
import com.val.controller.dto.Acciones;
import com.val.controller.dto.MensajeRespuesta;
import com.val.controller.dto.MensajeRespuestaFactory;
import com.val.controller.dto.Mensajes;
import com.val.controller.dto.EmailOlvido;
import com.val.persistence.entity.UsuarioE;
import com.val.service.interfaces.UsuarioServiceInterface;


@Controller
public class Olvido {
	
	@Autowired
    private ResourceBundleMessageSource mensajes;
	
	@Autowired
	private UsuarioServiceInterface usuario_service;
	
	private final static Logger log = Logger.getLogger("mylog");
	
	@RequestMapping(path = "/olvido", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public ResponseEntity<MensajeRespuesta> login(@RequestParam(value = "idioma", required = false) String lang, 
											@Valid @RequestBody EmailOlvido email_olvido, 
											BindingResult result) {
 
		UsuarioE usuario = null;
		MensajeRespuesta mensaje_respuesta = null;
		Accion accion = null;
		
		//TODO Este método debe:
				/**
				 * 1- Comprobar si la validación produjo errores y si los hubo, mostrar devolver el mensaje de error oportuno
				 * 2- En caso de que el mail sea correcto, hay que comprobar que exista en la base de datos (método existeCorreoUsuario de la UsuarioServiceInterface)
				 * 3- Si no existe, habrá que devolver una acción que informe al usuario de tal circustancia new Accion (Acciones.ACCION_INFORMAR_ERRORES_OLVIDO, Mensajes.MENSAJE_OLVIDO_KO)
				 * 4- Si existe, habrá que hacer uso del método recordarDatos (UsuarioServiceInterface) e informar al usuario del hecho (new Accion(Acciones.ACCION_INFORMAR_OK_OLVIDO, Mensajes.MENSAJE_OLVIDO_OK);
				 * Nota: capturar las execepciones que puedan producirse: registrándolas y progapagándolas
				 */
					
		return new ResponseEntity<MensajeRespuesta>(mensaje_respuesta, HttpStatus.OK);
	}
	

}
