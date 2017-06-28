package com.val.persistence.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.service.spi.InjectService;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.val.persistence.entity.UsuarioE;
import com.val.persistence.interfaces.UsuarioDaoInterface;


//Tanto repository, como service, como controller, son hijas de component
//son marcas que ayudan a spring a saber de qué va cada clase, cual es su función
//además de instanciarlas y dejarlas listas para la POA
//NOTA POA: Con POA podría decir: antes de entrar en una clase Service, haz no se qué
//Con Repository,le digo que puedo gnerar errores de acceso a base de datos, que requerirán
//la intervención de una clase de spring para su traducción y además, le informo que será
//singleton

@Repository
public class UsuarioDAO extends GenericDAO implements UsuarioDaoInterface {

	
	
	@Override
	public boolean existeUsuario(UsuarioE entity_usuario) 
	{
		boolean bdev = false;
		
			Query consulta = entityManager.createQuery("SELECT u FROM usuario u WHERE u.nombre = :nombre and u.pwd = :pwd");
			consulta.setParameter("nombre", entity_usuario.getNombre());
			consulta.setParameter("pwd", entity_usuario.getPwd());
		
			bdev = (consulta.getResultList().size()==1);
			
		return bdev;
	}
	
	@Override
	public UsuarioE existeMailUsuario(UsuarioE entity_usuario) 
	{
		UsuarioE usuarioe = null;
		
			Query consulta = entityManager.createQuery("SELECT u FROM usuario u WHERE u.email = :email");
			consulta.setParameter("email", entity_usuario.getEmail());
			
			List<UsuarioE> lista_usuarios = (List<UsuarioE>)consulta.getResultList();
			if (lista_usuarios.size() > 0)
			{
				usuarioe = (UsuarioE)lista_usuarios.get(0);
			}
			
			
		return usuarioe;
	}


	@Override
	Class getClase() {
		return UsuarioE.class;
	}


}
