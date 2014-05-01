/**
 * 
 */
package com.nokia.here.countletters;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ramon Michael
 *
 */
public class ProcessDefaultFilesImpl implements ProcessDefaultFiles {
	
	private final char PATH_CHARACTER = '/';
	
	public ProcessDefaultFilesImpl() {
	}
	
	@Override
	public void processFiles(Map<String,Integer> map,String fileName) {
		// JDK7 try-with-resources closes stream automatically			
		try (InputStream is = getClass().getResourceAsStream(PATH_CHARACTER + fileName)) {
			int bite;
			int lower = 0;
			while ((bite = is.read()) != -1) {
				if ((bite>=65 && bite<=90) || (bite>=97 && bite<=122)) {
					if (bite>=65 && bite<=90) {
						lower = bite + 32; 
					} else {
						lower = bite;
					}
					map.put(Integer.toString(lower), map.get(Integer.toString(lower))+1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Map<String,Integer> getEmptyAlphabetMap() {
		
		Map<String,Integer> map = new LinkedHashMap<>();
		for (int ch = 97; ch <= 122; ++ch) {
			map.put(String.valueOf(ch), 0);
		}
		return map;
	}

}
