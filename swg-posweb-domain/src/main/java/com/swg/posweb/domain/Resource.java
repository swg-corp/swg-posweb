/**
 * 
 */
package com.swg.posweb.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.swg.posweb.IResource;
import com.swg.posweb.ISkill;

/**
 * @author satriaprayoga
 *
 */
@Entity
public class Resource implements IResource {

	private static final long serialVersionUID = 4053914155923401989L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String username;
	private String password;
	private String realName;
	private String email;
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Skill> skills=new ArrayList<Skill>();
	@OneToMany(mappedBy="resource", fetch=FetchType.EAGER,
			cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, orphanRemoval=true)
	private List<Authority> authorities=new ArrayList<Authority>();
	@ManyToMany(mappedBy="resources", cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Project> projects=new ArrayList<Project>();
	@ManyToMany(mappedBy="resources", cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Todo> todos=new ArrayList<Todo>();
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	

}
