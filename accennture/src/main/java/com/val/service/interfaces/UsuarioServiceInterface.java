package com.val.service.interfaces;

import com.val.controller.dto.EmailOlvido;
import com.val.controller.dto.LoginUsuario;
import com.val.persistence.entity.UsuarioE;

public interface UsuarioServiceInterface {
	
	boolean existeUsuario (LoginUsuario login_usuario);
	UsuarioE existeCorreoUsuario(EmailOlvido email_olvido);
	void recordarDatos (UsuarioE usuarioE);
	UsuarioE leerUsuario (Object id);
	boolean borrarUsuario (Object id);
	

}
