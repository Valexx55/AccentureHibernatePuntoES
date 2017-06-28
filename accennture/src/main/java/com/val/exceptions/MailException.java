package com.val.exceptions;

/**
 * Clase para encapsular checked exceptions y que no se ensucie la interfaz
 * 
 * @author vale
 *
 */
public class MailException extends RuntimeException {

	
	private Throwable excepcion;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3339722632603412197L;
	
	
	public MailException (Throwable exception)
	{
		this.setExcepcion(exception);
	}


	public Throwable getExcepcion() {
		return excepcion;
	}


	public void setExcepcion(Throwable excepcion) {
		this.excepcion = excepcion;
	}
}
