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
public class Milestone implements IProject {
	private static final long serialVersionUID = -533024767015272693L;

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
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.swg.posweb.IProject#addChild(com.swg.posweb.IProject)
	 */
	@Override
	public void addChild(IProject child) {
		// TODO Auto-generated method stub

	}

}
