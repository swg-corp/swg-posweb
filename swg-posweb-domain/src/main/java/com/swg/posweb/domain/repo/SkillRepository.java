package com.swg.posweb.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swg.posweb.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long>,JpaSpecificationExecutor<Skill>{

}
