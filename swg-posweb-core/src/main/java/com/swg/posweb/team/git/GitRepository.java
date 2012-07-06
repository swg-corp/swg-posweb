/**
 * 
 */
package com.swg.posweb.team.git;

import org.eclipse.jgit.lib.Repository;

import com.swg.posweb.IShareableProject;
import com.swg.posweb.team.TeamRepository;

/**
 * @author satriaprayoga
 *
 */
public class GitRepository implements TeamRepository{

	private final Repository repository;
	private final IShareableProject project;
	
	public GitRepository(Repository repository,IShareableProject project) {
		this.repository=repository;
		this.project=project;
	}
	
	public Repository getRepository() {
		return repository;
	}
	
	@Override
	public IShareableProject getProject() {
		return project;
	}
}
