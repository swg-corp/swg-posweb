/**
 * 
 */
package com.swg.posweb.domain;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.io.FileUtils;

import com.swg.posweb.IDownloadable;
import com.swg.posweb.IProject;
import com.swg.posweb.IResource;
import com.swg.posweb.IShareableProject;
import com.swg.posweb.PoswebErrorException;

/**
 * @author satriaprayoga
 *
 */
@Entity
public class Project implements IShareableProject,IDownloadable {

	private static final long serialVersionUID = -5306494465708485893L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String projectName;
	private String projectManagerName;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Resource> resources=new ArrayList<Resource>();
	@OneToMany(mappedBy="project", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Milestone> milestones=new ArrayList<Milestone>();
	
	private String commitUrl;
	private String checkOutUrl;
	
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;
	private String projectTeamDir;
	
	@Transient
	private URL downloadUrl;
	private String fileName;
	private String downloadFolder;

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
	
	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public List<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	@Override
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectManagerName(String projectManagerName) {
		if(!resources.isEmpty() && projectManagerName.isEmpty()){
			this.projectManagerName=resources.get(0).getUsername();
		}else{
			this.projectManagerName = projectManagerName;
		}
		
	}
	
	public String getProjectManagerName() {
		projectManagerName=resources.get(0).getUsername();
		return projectManagerName;
	}
	
	
	@Override
	public IResource getProjectManager() {
		IResource resource=null;
		for(Resource res:getResources()){
			if(res.getUsername().equals(getProjectManagerName())){
				resource=res;
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
		return getMilestones();
	}

	
	@Override
	public void addChild(IProject child) {
		if(!Milestone.class.isAssignableFrom(child.getClass())){
			throw new PoswebErrorException("invalid child type");
		}
		Milestone milestone=(Milestone)child;
		milestone.setProject(this);
		milestones.add(milestone);
	}

	
	

	public String getCommitUrl() {
		return commitUrl;
	}

	public void setCommitUrl(String commitUrl) {
		this.commitUrl = commitUrl;
	}



	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getProjectTeamDir() {
		return projectTeamDir;
	}

	public void setProjectTeamDir(String projectTeamDir) {
		this.projectTeamDir = projectTeamDir;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownloadFolder() {
		return downloadFolder;
	}

	public void setDownloadFolder(String downloadFolder) {
		this.downloadFolder = downloadFolder;
	}

	@Override
	public URL getDownloadUrl() {
		return downloadUrl;
	}
	
	public void setDownloadUrl(URL downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	@Override
	public int getFileSize() {
		return (int) getFQNFile().length();
	}

	@Override
	public byte[] getFileData() {
		File file=getFQNFile();
		if(!file.exists()){
			throw new PoswebErrorException("File not found");
		}
		byte[] data=null;
		try {
			data=FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public File getFQNFile() {
		File fqn=new File(getDownloadFolder()+File.pathSeparator+getFileName());
		return fqn;
	}

	public String getCheckOutUrl() {
		return checkOutUrl;
	}

	public void setCheckOutUrl(String checkOutUrl) {
		this.checkOutUrl = checkOutUrl;
	}

	
}
