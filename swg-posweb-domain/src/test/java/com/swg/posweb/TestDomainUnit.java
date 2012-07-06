package com.swg.posweb;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swg.posweb.domain.Resource;
import com.swg.posweb.domain.repo.ResourceRepository;

@ContextConfiguration(locations="classpath*:META-INF/spring/*-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDomainUnit {

	final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	ResourceRepository resourceRepository;
	
	@Test
	public void testDomain(){
		Resource resource=new Resource();
		resource.setUsername("aing");
		resource.setPassword("sudah_betul");
		resource.setRealName("Aing Pisan Lah");
		resource=resourceRepository.save(resource);
		logger.info("id: "+resource.getId());
		
	}
}
