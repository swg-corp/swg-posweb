/**
 * 
 */
package com.swg.posweb.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swg.posweb.domain.Todo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author satriaprayoga
 *
 */
public interface TodoRepository extends JpaRepository<Todo, Long>,JpaSpecificationExecutor<Todo> {

}
