/**
 * 
 */
package com.swg.posweb.service.callback;

import com.swg.posweb.domain.Resource;
import com.swg.posweb.util.CryptUtil;

/**
 * @author satriaprayoga
 *
 */
public class EncodePasswordCallback extends CrudCallbackAdapter<Resource> {
	
	private final String alghoritm;
	
	public EncodePasswordCallback() {
		this("MD5");
	}
	
	public EncodePasswordCallback(String alghoritm) {
		this.alghoritm=alghoritm;
	}
	

	@Override
	public void onCreate(Resource resource) {
		String password=resource.getPassword();
		if(alghoritm.equals("SHA1"))
			password=CryptUtil.getSHA1(password);
		else
			password=CryptUtil.getMD5(password);
		resource.setPassword(password);
	}

	

}
