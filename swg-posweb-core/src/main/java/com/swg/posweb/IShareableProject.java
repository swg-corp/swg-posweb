/**
 * 
 */
package com.swg.posweb;

import java.util.Date;

/**
 * @author satriaprayoga
 *
 */
public interface IShareableProject extends IProject{

	String getCommitUrl();
	Date getLastUpdate();
	String getCheckOutUrl();
	String getProjectTeamDir();
}
