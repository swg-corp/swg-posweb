/**
 * 
 */
package com.swg.posweb.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swg.posweb.domain.Resource;
import com.swg.posweb.domain.repo.ResourceRepository;
import com.swg.posweb.service.AbstractCrudService;
import com.swg.posweb.service.PoswebServiceException;
import com.swg.posweb.service.callback.AuthorityResourceCallback;
import com.swg.posweb.service.callback.EncodePasswordCallback;


/**
 * @author satriaprayoga
 *
 */
@Service
public class PoswebResourceService extends AbstractCrudService<Resource> implements ResourceService,InitializingBean{

	@Autowired
	private ResourceRepository resourceRepository;
	
	public PoswebResourceService() {
		super();
	}
	
	@Override
	public Resource create(Resource obj) throws PoswebServiceException {
		Resource resource=super.create(obj);
		return resourceRepository.save(resource);
	}
	
	@Override
	public Resource delete(Resource obj) throws PoswebServiceException {
		Resource resource=super.delete(obj);
		resourceRepository.delete(resource);
		return resource;
	}
	
	@Override
	public Resource findByUsername(String username) {
		if(username==null || username.isEmpty()){
			throw new PoswebServiceException();
		}
		return resourceRepository.findByUsername(username);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		addCallback(new EncodePasswordCallback());
		addCallback(new AuthorityResourceCallback());
	}


}
