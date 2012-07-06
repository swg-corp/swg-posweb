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

	/* (non-Javadoc)
	 * @see com.swg.posweb.IProject#getProjectName()
	 */
	@Override
	public String getProjectName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.swg.posweb.IProject#getProjectManager()
	 */
	@Override
	public IResource getProjectManager() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.swg.posweb.IProject#getParent()
	 */
	@Override
	public IProject getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.swg.posweb.IProject#getChilds()
	 */
	@Override
	public List<? extends IProject> getChilds() {
		throw new UnsupportedOperationException(getClass().getName()+" does not have a child");
	}

	/* (non-Javadoc)
	 * @see com.swg.posweb.IProject#addChild(com.swg.posweb.IProject)
	 */
	@Override
	public void addChild(IProject child) {
		throw new UnsupportedOperationException(getClass().getName()+" does not have a child");
	}

}
