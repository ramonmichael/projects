/**
 * 
 */
package com.nokia.here.countletters;

import java.util.Map;


/**
 * @author Ramon Michael
 *
 */
public interface ProcessDefaultFiles {
	
	public void processFiles(Map<String,Integer> map, String fileName);
	public Map<String,Integer> getEmptyAlphabetMap();

}
