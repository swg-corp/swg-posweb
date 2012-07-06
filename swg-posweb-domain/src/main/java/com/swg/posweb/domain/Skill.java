/**
 * 
 */
package com.swg.posweb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.swg.posweb.ISkill;

/**
 * @author satriaprayoga
 *
 */
@Entity
public class Skill implements ISkill{
	private static final long serialVersionUID = -5469770442754845342L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String skillName;
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="skills")
	private List<Resource> resources=new ArrayList<Resource>();

	public Skill() {
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public Skill(String skillName){
		this.skillName=skillName;
	}
	
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	@Override
	public String getSkillName() {
		return skillName;
	}
	
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	public List<Resource> getResources() {
		return resources;
	}
	

}
