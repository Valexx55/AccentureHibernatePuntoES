package com.val.persistence.interfaces;


public interface CRUD {
	
		 
	    boolean create(Object entity);
	    Object read(Object id);
	    boolean update(Object entity);
	    boolean delete(Object entity);


}
