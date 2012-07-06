/**
 * 
 */
package com.swg.posweb.service;

import com.swg.posweb.PoswebErrorException;

/**
 * @author satriaprayoga
 *
 */
public class PoswebServiceException extends PoswebErrorException {
	private static final long serialVersionUID = -309540715347426824L;

	public PoswebServiceException() {
		super();
	}

	public PoswebServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PoswebServiceException(String message) {
		super(message);
	}
	
	

}
