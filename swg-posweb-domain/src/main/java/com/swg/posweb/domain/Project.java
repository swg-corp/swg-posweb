/**
 * 
 */
package com.swg.posweb.domain;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.swg.posweb.IDownloadable;
import com.swg.posweb.IProject;
import com.swg.posweb.IResource;
import com.swg.posweb.IShareableProject;

/**
 * @author satriaprayoga
 *
 */
public class Project implements IShareableProject,IDownloadable {

	private static final long serialVersionUID = -5306494465708485893L;
	
	private Long id;
	private String projectName;
	private String projectManagerName;
	private Date startDate;
	private Date endDate;
	
	private List<Resource> resources;

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	@Override
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}
	
	public String getProjectManagerName() {
		return projectManagerName;
	}
	
	
	@Override
	public IResource getProjectManager() {
		IResource resource=null;
		for(Resource r:resources){
			if(r.getUsername().equals(projectManagerName)){
				resource=r;
			}
		}
		return resource;
	}

	@Override
	public IProject getParent() {
		throw new UnsupportedOperationException(getClass().getName()+" does not have a parent");
	}

	
	@Override
	public List<? extends IProject> getChilds() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void addChild(IProject child) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public String getCommitUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Date getLastUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCheckOutUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getDownloadUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFileSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] getFileData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDownloadFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getFQNFile() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getProjectTeamDir() {
		// TODO Auto-generated method stub
		return null;
	}

}
