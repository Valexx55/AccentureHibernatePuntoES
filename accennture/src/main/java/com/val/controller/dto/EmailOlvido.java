package com.val.controller.dto;

import javax.validation.constraints.Pattern;

public class EmailOlvido {
	
	
	@Pattern(regexp="\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(.\\w{2,4})+")
	private String mail;
	
	public EmailOlvido () {}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return this.mail;
	}

}
