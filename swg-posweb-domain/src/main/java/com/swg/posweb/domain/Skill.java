/**
 * 
 */
package com.swg.posweb.domain;

import com.swg.posweb.ISkill;

/**
 * @author satriaprayoga
 *
 */
public class Skill implements ISkill{
	private static final long serialVersionUID = -5469770442754845342L;
	
	private String skillName;

	public Skill() {
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

}
