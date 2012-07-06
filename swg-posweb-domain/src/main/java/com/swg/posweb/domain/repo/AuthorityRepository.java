/**
 * 
 */
package com.swg.posweb.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swg.posweb.domain.Authority;

/**
 * @author satriaprayoga
 *
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long>,JpaSpecificationExecutor<Authority>{

}
