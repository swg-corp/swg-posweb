/**
 * 
 */
package com.swg.posweb.domain.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swg.posweb.domain.Milestone;
import com.swg.posweb.domain.Todo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author satriaprayoga
 *
 */
public interface TodoRepository extends JpaRepository<Todo, Long>,JpaSpecificationExecutor<Todo> {

	List<Todo> findByMilestone(Milestone milestone);
}
