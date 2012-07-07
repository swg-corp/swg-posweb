/**
 * 
 */
package com.swg.posweb.service.callback;

import com.swg.posweb.service.CrudCallback;

/**
 * @author satriaprayoga
 *
 */
public abstract class CrudCallbackAdapter<T> implements CrudCallback<T> {

	public void onCreate(T resource) {}
	public void onDelete(T resource) {}
	public void onUpdate(T resource) {}
}
