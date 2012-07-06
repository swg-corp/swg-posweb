/**
 * 
 */
package com.swg.posweb.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author satriaprayoga
 *
 */
public abstract class AbstractCrudService<T> implements CrudService<T>{

	private List<ServiceCallback<T>> callbacks;

	public AbstractCrudService() {
		callbacks=new LinkedList<ServiceCallback<T>>();
	}
	
	public T create(T obj) throws PoswebServiceException {
		if(!isCallbackEmpty()){
			for(ServiceCallback<T> sc:callbacks){
				if(CrudCallback.class.isAssignableFrom(sc.getClass())){
					CrudCallback<T> c=(CrudCallback<T>)sc;
					c.onCreate(obj);
				}
			}
		}
		return obj;
	}
	
	public T delete(T obj) throws PoswebServiceException {
		if(!isCallbackEmpty()){
			for(ServiceCallback<T> sc:callbacks){
				if(CrudCallback.class.isAssignableFrom(sc.getClass())){
					CrudCallback<T> c=(CrudCallback<T>)sc;
					c.onDelete(obj);
				}
			}
		}
		return obj;
	}
	
	public T update(T obj) throws PoswebServiceException {
		if(!isCallbackEmpty()){
			for(ServiceCallback<T> sc:callbacks){
				if(CrudCallback.class.isAssignableFrom(sc.getClass())){
					CrudCallback<T> c=(CrudCallback<T>)sc;
					c.onUpdate(obj);
				}
			}
		}
		return obj;
	}

	@Override
	public void addCallback(ServiceCallback<T> callback) {
		callbacks.add(callback);
	}

	@Override
	public Collection<ServiceCallback<T>> getCallbacks() {
		return callbacks;
	}


	public boolean isCallbackEmpty(){
		return false;
	}


}
