package com.devsupeiror.dscatalog.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1l;
	
	public EntityNotFoundException (String msg) {
		super(msg);
	}
}
