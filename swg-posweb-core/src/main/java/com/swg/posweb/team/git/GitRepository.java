/**
 * 
 */
package com.swg.posweb.team.git;

import org.eclipse.jgit.lib.Repository;

import com.swg.posweb.team.TeamRepository;

/**
 * @author satriaprayoga
 *
 */
public class GitRepository implements TeamRepository{

	private final Repository repository;
	
	public GitRepository(Repository repository) {
		this.repository=repository;
	}
	
	public Repository getRepository() {
		return repository;
	}
}
