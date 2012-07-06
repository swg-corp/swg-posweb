/**
 * 
 */
package com.swg.posweb.service;

import java.util.Collection;


/**
 * @author satriaprayoga
 *
 */
public interface ServiceCallbackAware<T> {

	void addCallback(ServiceCallback<T> callback);
	
	Collection<ServiceCallback<T>> getCallbacks();

}
