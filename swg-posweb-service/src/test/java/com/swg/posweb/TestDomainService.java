/**
 * 
 */
package com.swg.posweb;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swg.posweb.domain.Resource;
import com.swg.posweb.service.ResourceService;

/**
 * @author satriaprayoga
 *
 */
@ContextConfiguration(locations="classpath*:META-INF/spring/*-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDomainService {

	final Logger logger=Logger.getLogger(getClass());

	@Autowired
	ResourceService resourceService;

	
	@Test
	public void runTest(){
		Resource resource=new Resource();
		resource.setUsername("aing");
		resource.setPassword("sudah_betul");
		resource.setRealName("Aing Pisan Lah");
		logger.info("before service callback: password= "+resource.getPassword());
		resource=resourceService.create(resource);
		logger.info("after service callback: password= "+resource.getPassword());
	}
}
