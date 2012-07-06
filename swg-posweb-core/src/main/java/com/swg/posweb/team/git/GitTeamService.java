/**
 * 
 */
package com.swg.posweb.team.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import com.swg.posweb.IShareableProject;
import com.swg.posweb.PoswebErrorException;
import com.swg.posweb.team.TeamRepository;
import com.swg.posweb.team.TeamService;

/**
 * @author satriaprayoga
 *
 */
public class GitTeamService implements TeamService{

	@Override
	public TeamRepository createRepository(IShareableProject project)
			throws PoswebErrorException {
		TeamRepository repository=null;
		Repository r=null;
		try{
			FileRepositoryBuilder builder=new FileRepositoryBuilder();
			r=builder.setGitDir(new File(project.getProjectTeamDir()))
					.readEnvironment()
					.findGitDir()
					.build();
			repository=new GitRepository(r,project);
		}catch(IOException e){
			throw new PoswebErrorException("failed to build "+project.getProjectName()+" repository",e);
		}
		return repository;
	}

}
