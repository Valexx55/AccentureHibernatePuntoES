package com.val.controller.dto;

import javax.validation.constraints.Pattern;

public class LoginUsuario {
	
	@Pattern(regexp="\\w{6,45}")
	private String nombre;
	@Pattern(regexp="\\w{6,45}")
	private String pwd;
	
	
	public LoginUsuario () {}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre_usuario) {
		this.nombre = nombre_usuario;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombre + " " + this.pwd;
	}

}
