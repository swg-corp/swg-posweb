/**
 * 
 */
package com.swg.posweb.domain.service.callback;

import com.swg.posweb.domain.Authority;
import com.swg.posweb.domain.Resource;
import com.swg.posweb.service.CrudCallback;

/**
 * @author satriaprayoga
 *
 */
public class AuthorityResourceCallback implements CrudCallback<Resource>{

	@Override
	public void onCreate(Resource resource) {
		Authority authority=new Authority();
		authority.setResource(resource);
		resource.getAuthorities().add(authority);
		authority.setRole("ROLE_DEVELOPER");
	}

	@Override
	public void onDelete(Resource resource) {
		
	}

	@Override
	public void onUpdate(Resource resource) {
		
	}

}
