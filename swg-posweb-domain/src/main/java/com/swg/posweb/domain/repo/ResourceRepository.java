/**
 * 
 */
package com.swg.posweb.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swg.posweb.domain.Resource;

/**
 * @author satriaprayoga
 *
 */
public interface ResourceRepository extends JpaRepository<Resource, Long>,JpaSpecificationExecutor<Resource>{

	Resource findByUsername(String username);
}
