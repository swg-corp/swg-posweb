/**
 * 
 */
package com.swg.posweb.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swg.posweb.domain.Project;

/**
 * @author satriaprayoga
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Long>,JpaSpecificationExecutor<Project>{

}
