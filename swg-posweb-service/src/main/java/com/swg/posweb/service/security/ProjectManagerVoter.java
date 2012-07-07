/**
 * 
 */
package com.swg.posweb.service.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import com.swg.posweb.domain.Project;

/**
 * @author satriaprayoga
 *
 */
public class ProjectManagerVoter implements AccessDecisionVoter<Project>{
	
	public static final String PM_PREFIX="PM_";

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int vote(Authentication authentication, Project object,
			Collection<ConfigAttribute> attributes) {

		return 0;
	}

	

}
