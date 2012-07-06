/**
 * 
 */
package com.swg.posweb;

import java.io.File;
import java.net.URL;

/**
 * @author satriaprayoga
 *
 */
public interface IDownloadable {

	URL getDownloadUrl();
	
	int getFileSize();
	
	byte[] getFileData();
	
	String getDownloadFolder();
	
	String getFileName();
	
	File getFQNFile();
}
