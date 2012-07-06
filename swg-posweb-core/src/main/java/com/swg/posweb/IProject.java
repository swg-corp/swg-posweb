/**
 * 
 */
package com.swg.posweb;

import java.io.Serializable;
import java.util.List;

/**
 * @author satriaprayoga
 *
 */
public interface IProject extends Serializable{

	String getProjectName();
	IResource getProjectManager();
	IProject getParent();
	List<? extends IProject> getChilds();
	void addChild(IProject child);
}
