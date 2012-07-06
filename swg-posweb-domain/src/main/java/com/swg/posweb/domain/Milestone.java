/**
 * 
 */
package com.swg.posweb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.swg.posweb.IProject;
import com.swg.posweb.IResource;
import com.swg.posweb.PoswebErrorException;

/**
 * @author satriaprayoga
 *
 */
public class Milestone implements IProject {
	private static final long serialVersionUID = -533024767015272693L;
	
	private Long id;
	
	private Project project;
	
	private List<Todo> todos=new ArrayList<Todo>();
	
	private String milestoneName;
	
	private Date startDate;
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
