/**
 * 
 */
package com.swg.posweb.service;


/**
 * @author satriaprayoga
 *
 */
public interface CrudCallback<R> extends ServiceCallback<R> {

	void onCreate(R resource);
	void onDelete(R resource);
	void onUpdate(R resource);
}
