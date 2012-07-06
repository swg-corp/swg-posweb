/**
 * 
 */
package com.swg.posweb.domain;

import java.util.List;

import com.swg.posweb.IProject;
import com.swg.posweb.IResource;

/**
 * @author satriaprayoga
 *
 */
public class Todo implements IProject {
	private static final long serialVersionUID = -6060873031816214518L;
	
	private Milestone milestone;
	
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

}
