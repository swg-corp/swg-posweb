/**
 * 
 */
package com.swg.posweb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.swg.posweb.IProject;
import com.swg.posweb.IResource;

/**
 * @author satriaprayoga
 *
 */
@Entity
public class Todo implements IProject {
	private static final long serialVersionUID = -6060873031816214518L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String todoName;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateLine;
	@ManyToOne
	private Milestone milestone;
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Resource> resources=new ArrayList<Resource>();
	@Transient
	private String status="active";
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateLine() {
		return dateLine;
	}

	public void setDateLine(Date dateLine) {
		this.dateLine = dateLine;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}
	
	public Milestone getMilestone() {
		return milestone;
	}

	@Override
	public String getProjectName() {
		return milestone.getProjectName();
	}

	
	@Override
	public IResource getProjectManager() {
		return milestone.getProjectManager();
	}

	
	@Override
	public IProject getParent() {
		return getMilestone();
	}


	@Override
	public List<? extends IProject> getChilds() {
		throw new UnsupportedOperationException(getClass().getName()+" must not have a child");
	}

	
	@Override
	public void addChild(IProject child) {
		throw new UnsupportedOperationException(getClass().getName()+" must not have a child");
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
