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
import com.val.controller.dto.PaginasHTML;
import com.val.controller.dto.LoginUsuario;
import com.val.service.interfaces.UsuarioServiceInterface;


@Controller
public class Login {
	
	@Autowired
    private ResourceBundleMessageSource mensajes;
	
	@Autowired//es la versión de Spring de Inject, que seria el estándar JAVA JSR 229 // Resource es igual, pero más fino, porque te permite filtar por el NOMBRE del bean a la hora de inyectar y no sólo por el tipo (con o cual, si tienes varios beans del mismo tipo pero con distitno nombre, Resource sería sensible a esta circustancia y Inject o Autowired NO
	private UsuarioServiceInterface usuario_service;
	
	private final static Logger log = Logger.getLogger("mylog");
	
	@RequestMapping(path = "/login", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public ResponseEntity<MensajeRespuesta> login(@RequestParam(value = "idioma", required = false) String lang, @Valid @RequestBody LoginUsuario login_usuario, BindingResult result) {
 
		Accion accion = null;
		MensajeRespuesta mensaje_respuesta = null;
		
				boolean hay_errores = false;
				hay_errores = result.hasErrors();
				
				if (hay_errores)
				{
					
					String str_aux = mensajes.getMessage(result.getFieldError(), new Locale (lang)); 
					accion = new Accion(Acciones.ACCION_INFORMAR_ERRORES_LOGIN, str_aux);
					
				} else
					{
					
						try {
							
								if (usuario_service.existeUsuario(login_usuario))
								{
									accion = new Accion (Acciones.ACCION_REDIRIGIR, PaginasHTML.PAG_INICIO_CLIENTE);
								} 
									else 
										{
											accion = new Accion (Acciones.ACCION_INFORMAR_ERRORES_LOGIN, Mensajes.MENSAJE_USARIO_LOGIN_KO);
										}
							
							} catch (Throwable t) 
							{ //Estrategia mixta, capturo y propago para : 1) que quede constancia del error LOG y 2) para que el usuario sea informado propiamente
								
									log.error("Error en acceso a base de datos", t);//chapeau
									throw t; //IMPORTANTÍSIMO
							}
					}
				
				mensaje_respuesta = MensajeRespuestaFactory.crearRespuesta(accion);
				
		return new ResponseEntity<MensajeRespuesta>(mensaje_respuesta, HttpStatus.OK);
	}
	
 

}
