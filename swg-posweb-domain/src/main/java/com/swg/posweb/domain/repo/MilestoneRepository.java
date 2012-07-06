/**
 * 
 */
package com.swg.posweb.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swg.posweb.domain.Milestone;

/**
 * @author satriaprayoga
 *
 */
public interface MilestoneRepository extends JpaRepository<Milestone, Long>,JpaSpecificationExecutor<Milestone>{

}
