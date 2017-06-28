package com.val.persistence.interfaces;

import com.val.persistence.entity.UsuarioE;

public interface UsuarioDaoInterface extends CRUD {
	
	boolean existeUsuario (UsuarioE entity_usuario);
	UsuarioE existeMailUsuario(UsuarioE entity_usuario);
	

}
