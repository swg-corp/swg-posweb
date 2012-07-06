/**
 * 
 */
package com.swg.posweb.team;

import java.util.Set;

import com.swg.posweb.IProject;

/**
 * @author satriaprayoga
 *
 */
public interface PermissionModel {

	public static enum PermissionMode{
		CREATE_PROJECT,UPDATE_PROJECT,DELETE_PROJECT
	}
	
	IProject getWorkingProject();
	Set<PermissionMode> getPermissionMode();
	void addPermissionMode(PermissionMode permissionFlag);
	boolean isCreateEnable();
	boolean isDeleteEnable();
	boolean isUpdateEnable();

}
