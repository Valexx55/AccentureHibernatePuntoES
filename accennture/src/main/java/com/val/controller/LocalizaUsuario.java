package com.val.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.val.persistence.entity.UsuarioE;
import com.val.service.interfaces.UsuarioServiceInterface;


@Controller
public class LocalizaUsuario {
	
	
	
	@Autowired//es la versión de Spring de Inject, que seria el estándar JAVA JSR 229 // Resource es igual, pero más fino, porque te permite filtar por el NOMBRE del bean a la hora de inyectar y no sólo por el tipo (con o cual, si tienes varios beans del mismo tipo pero con distitno nombre, Resource sería sensible a esta circustancia y Inject o Autowired NO
	private UsuarioServiceInterface usuario_service;
	
	private final static Logger log = Logger.getLogger("mylog");
	
	@RequestMapping(value = "/usuario/json/{id}", method=RequestMethod.GET, produces="application/json" )
	@ResponseBody
	public UsuarioE getUsuarioJSON(@PathVariable String id){
		UsuarioE p = null;
		
		//TODO GET --> recuperaría la información de la persona con ése nombre
		
		p = usuario_service.leerUsuario(Integer.parseInt(id));
		
		
		log.debug("USUARIO = " + p);
		
		return p;
	}	
	
	@RequestMapping(value = "/usuario/json/{id}", method=RequestMethod.DELETE, produces="application/json" )
	@ResponseBody
	public UsuarioE deleteUsuarioJSON(@PathVariable String id){
		UsuarioE p = null;
		
		//TODO GET --> recuperaría la información de la persona con ése nombre
		
			p = usuario_service.leerUsuario(Integer.parseInt(id));
			usuario_service.borrarUsuario (id);
			
			log.debug("USUARIO = " + p);
		
		return p;
	}	
	
	@RequestMapping(value = "/usuario/xml/{id}", method=RequestMethod.GET, produces="application/xml" )
	@ResponseBody
	public UsuarioE getUsuarioXML(@PathVariable String id){
			UsuarioE p = null;
			
			//TODO GET --> recuperaría la información de la persona con ése nombre
			
			p = usuario_service.leerUsuario(Integer.parseInt(id));
			
			log.debug("USUARIO = " + p);
			
			return p;
	}
 

}
