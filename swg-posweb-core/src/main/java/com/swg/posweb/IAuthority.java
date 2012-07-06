/**
 * 
 */
package com.swg.posweb;

import java.io.Serializable;

/**
 * @author satriaprayoga
 *
 */
public interface IAuthority extends Serializable{

	String getRole();
	String getPassword();
	String getUsername();
	IResource getAuthResource();
}
