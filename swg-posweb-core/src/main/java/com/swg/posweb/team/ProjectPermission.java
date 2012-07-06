/**
 * 
 */
package com.swg.posweb.team;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.swg.posweb.IProject;
import com.swg.posweb.PoswebException;

/**
 * @author satriaprayoga
 *
 */
public abstract class ProjectPermission {
	
	
	private final Map<String, PermissionModel> permisionMap;
	
	public ProjectPermission() {
		permisionMap=new HashMap<String, PermissionModel>();
	}
	
	public boolean hasPermision(String identifier)throws PoswebException{
		return (permisionMap.containsKey(identifier));
	}
	
	public PermissionModel getPermissionModel(String identifier) throws PoswebException{
		PermissionModel model=null;
		if(!hasPermision(identifier)){
			model=new SimplePermissionModel(null);
			permisionMap.put(identifier, model);
			
		}else{
			model=permisionMap.get(identifier);
		}
		return model;
		
	}
	
	static class SimplePermissionModel implements PermissionModel{

		private final IProject workingProject;
		private final Set<PermissionMode> modes;
		
		public SimplePermissionModel(IProject project) {
			this.workingProject=project;
			this.modes=new HashSet<PermissionModel.PermissionMode>();
		}
		
		@Override
		public IProject getWorkingProject() {
			return workingProject;
		}

		@Override
		public Set<PermissionMode> getPermissionMode() {
			return modes;
		}

		@Override
		public void addPermissionMode(PermissionMode permissionFlag) {
			modes.add(permissionFlag);
		}

		@Override
		public boolean isCreateEnable() {
			return modes.contains(PermissionMode.CREATE_PROJECT);
		}

		@Override
		public boolean isDeleteEnable() {
			return modes.contains(PermissionMode.DELETE_PROJECT);
		}

		@Override
		public boolean isUpdateEnable() {
			return modes.contains(PermissionMode.UPDATE_PROJECT);
		}
		
	}
}
