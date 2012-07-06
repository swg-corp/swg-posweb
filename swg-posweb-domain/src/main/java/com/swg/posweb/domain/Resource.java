/**
 * 
 */
package com.swg.posweb.domain;

import java.util.List;

import com.swg.posweb.IResource;
import com.swg.posweb.ISkill;

/**
 * @author satriaprayoga
 *
 */
public class Resource implements IResource {

	private static final long serialVersionUID = 4053914155923401989L;

	private String username;
	private String password;
	private String realName;
	private String email;
	
	private List<Skill> skills;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String getPassword() {
		return password;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Override
	public String getRealName() {
		return realName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getEmail() {
		return email;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	@Override
	public List<? extends ISkill> getSkills() {
		return skills;
	}

}
