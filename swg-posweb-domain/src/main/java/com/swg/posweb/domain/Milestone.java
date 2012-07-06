/**
 * 
 */
package com.swg.posweb.domain;

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
	
	private Project project;
	
	private List<Todo> todos;


	@Override
	public String getProjectName() {
		return project.getProjectName();
	}

	
	@Override
	public IResource getProjectManager() {
		return project.getProjectManager();
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

}
