/**
 * 
 */
package com.swg.posweb.team;

import com.swg.posweb.IShareableProject;
import com.swg.posweb.PoswebErrorException;

/**
 * @author satriaprayoga
 *
 */
public interface TeamService {

	TeamRepository createRepository(IShareableProject project) throws PoswebErrorException;
}
