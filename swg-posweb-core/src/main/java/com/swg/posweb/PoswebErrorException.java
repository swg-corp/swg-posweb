/**
 * 
 */
package com.swg.posweb;

/**
 * @author satriaprayoga
 *
 */
public class PoswebErrorException extends RuntimeException {
	private static final long serialVersionUID = -4688631689523968967L;
	
	public PoswebErrorException() {
	}

	public PoswebErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public PoswebErrorException(String message) {
		super(message);
	}
	
}
