/**
 * 
 */
package com.swg.posweb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.swg.posweb.IAuthority;
import com.swg.posweb.IResource;

/**
 * @author satriaprayoga
 *
 */
@Entity
public class Authority implements IAuthority{
	private static final long serialVersionUID = -8180182871443585192L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Resource resource;
	private String role;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getRole() {
		return role;
	}

	@Override
	public String getPassword() {
		return resource.getPassword();
	}

	@Override
	public String getUsername() {
		return resource.getUsername();
	}

	@Override
	public IResource getAuthResource() {
		return getResource();
	}

}
