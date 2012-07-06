/**
 * 
 */
package com.swg.posweb.service;

/**
 * @author satriaprayoga
 *
 */
public interface CrudService<T> extends ServiceCallbackAware<T> {

	T create(T obj) throws PoswebServiceException;
	T delete(T obj) throws PoswebServiceException;
	T update(T obj) throws PoswebServiceException;
}
