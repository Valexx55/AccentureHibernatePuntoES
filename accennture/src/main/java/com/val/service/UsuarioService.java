package com.val.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.val.controller.dto.EmailOlvido;
import com.val.controller.dto.LoginUsuario;
import com.val.persistence.entity.UsuarioE;
import com.val.persistence.interfaces.UsuarioDaoInterface;
import com.val.service.interfaces.UsuarioServiceInterface;

@Service
public class UsuarioService implements UsuarioServiceInterface {
	
	@Autowired
	UsuarioDaoInterface usuarioDAO;

	@Override
	@Transactional
	public boolean existeUsuario(LoginUsuario login_usuario) {
		UsuarioE e_usuario = null;
		
			e_usuario = new UsuarioE(login_usuario.getNombre(), login_usuario.getPwd());
		
		return usuarioDAO.existeUsuario(e_usuario);
	}

	@Override
	public void recordarDatos(UsuarioE usuarioE) 
	{
			 Email.enviarEmailOlvido(usuarioE);
	}

	@Override
	@Transactional
	public UsuarioE existeCorreoUsuario(EmailOlvido email_olvido) {
		UsuarioE e_usuario = null;
		
			e_usuario = new UsuarioE();
			e_usuario.setEmail(email_olvido.getMail());
	
		return usuarioDAO.existeMailUsuario(e_usuario);
	}

	@Override
	@Transactional
	public UsuarioE leerUsuario(Object id) {
		UsuarioE ue = null;
		
			ue = (UsuarioE) usuarioDAO.read(id);
		
		return ue;
	}
	
	@Override
	@Transactional
	public boolean borrarUsuario(Object id) {
		boolean vdev = false;

			vdev = usuarioDAO.delete(id);
		
		return vdev;
	}

}
