/**
 * 
 */
package com.swg.posweb.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	
	private List<Skill> skills=new ArrayList<Skill>();
	private List<Authority> authorities=new ArrayList<Authority>();
	
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
	
	public List<Authority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public Set<String> getRoles() {
		Set<String> roles=new java.util.HashSet<String>();
		for(Authority a:authorities){
			roles.add(a.getRole());
		}
		return roles;
	}
	
	public void addRole(Authority a){
		a.setResource(this);
		getAuthorities().add(a);
	}

}
