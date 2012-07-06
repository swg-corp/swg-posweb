/**
 * 
 */
package com.swg.posweb.service;

import com.swg.posweb.domain.Resource;
import com.swg.posweb.service.CrudService;

/**
 * @author satriaprayoga
 *
 */
public interface ResourceService extends CrudService<Resource>{

	Resource findByUsername(String username);
}
