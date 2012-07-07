/**
 * 
 */
package com.swg.posweb.service.callback;

import com.swg.posweb.domain.Authority;
import com.swg.posweb.domain.Resource;

/**
 * @author satriaprayoga
 *
 */
public class AuthorityResourceCallback extends CrudCallbackAdapter<Resource>{

	@Override
	public void onCreate(Resource resource) {
		Authority authority=new Authority();
		authority.setResource(resource);
		resource.getAuthorities().add(authority);
		authority.setRole("ROLE_DEVELOPER");
	}

}
