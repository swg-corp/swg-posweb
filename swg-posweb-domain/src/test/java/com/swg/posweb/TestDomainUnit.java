package com.swg.posweb;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swg.posweb.domain.Project;
import com.swg.posweb.domain.Resource;
import com.swg.posweb.domain.repo.ProjectRepository;
import com.swg.posweb.domain.repo.ResourceRepository;

@ContextConfiguration(locations="classpath*:META-INF/spring/*-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDomainUnit {

	final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Test
	public void testDomainResources(){
		Resource resource=new Resource();
		resource.setUsername("aing");
		resource.setPassword("sudah_betul");
		resource.setRealName("Aing Pisan Lah");
		resource=resourceRepository.save(resource);
		logger.info("id: "+resource.getId());
		
	}
	
	@Test
	public void testDomainProjects(){
		Resource pm=resourceRepository.findByUsername("aing");
		logger.info(pm.getRealName());
		Project project=new Project();
		project.setProjectName("Project oh yeah");
		project=projectRepository.save(project);
		project.getResources().add(pm);
		projectRepository.saveAndFlush(project);
		logger.info("project manager name: "+project.getProjectManagerName());
	}
	
	@Test
	public void testFindDomainProjects(){
		Project found=projectRepository.findByProjectName("Project oh yeah");
		logger.info("found project: "+found.getProjectName()+", pm: "+found.getProjectManagerName());
		IResource resource=found.getProjectManager();
		logger.info("resource username: "+resource.getUsername());
	}
}
