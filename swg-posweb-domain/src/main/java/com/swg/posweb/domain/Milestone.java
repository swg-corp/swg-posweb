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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.swg.posweb.IProject;
import com.swg.posweb.IResource;
import com.swg.posweb.PoswebErrorException;

/**
 * @author satriaprayoga
 *
 */
@Entity
public class Milestone implements IProject {
	private static final long serialVersionUID = -533024767015272693L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Project project;
	
	@OneToMany(mappedBy="milestone", cascade=CascadeType.ALL)
	private List<Todo> todos=new ArrayList<Todo>();
	
	private String milestoneName;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	
	public String getMilestoneName() {
		return milestoneName;
	}


	@Override
	public String getProjectName() {
		return project.getProjectName();
	}

	
	@Override
	public IResource getProjectManager() {
		return project.getProjectManager();
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Project getProject() {
		return project;
	}

	
	@Override
	public IProject getParent() {
		return project;
	}

	
	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	
	public List<Todo> getTodos() {
		return todos;
	}
	
	@Override
	public List<? extends IProject> getChilds() {
		return getTodos();
	}


	@Override
	public void addChild(IProject child) {
		if(!(child instanceof Todo)){
			throw new PoswebErrorException("invalid child type");
		}
		Todo todo=(Todo)child;
		todos.add(todo);
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
}
