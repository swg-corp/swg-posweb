/**
 * 
 */
package com.swg.posweb;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author satriaprayoga
 *
 */
public interface IResource extends Serializable{

	String getUsername();
	String getPassword();
	String getRealName();
	String getEmail();
	List<? extends ISkill> getSkills();
	Set<String> getRoles();
}
