/**
 * 
 */
package com.nokia.here.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @author Ramon Michael
 * 
 */
public class CountLettersTest {
	
	private final char PATH_CHARACTER = '/';
	private final String femaleFile = "1000-female-names.txt";
	private final String maleFile = "1000-males-names.txt";

	@Test
	public void testFilesExistAndToStream() {
		assertNotNull("Test file missing", getClass().getResource(PATH_CHARACTER + femaleFile));
		assertNotNull("Test file missing", getClass().getResource(PATH_CHARACTER + maleFile));
	}

	@Test
	public void testFilesToStream() {
		// JDK7 try-with-resources closes stream automatically
		try (InputStream is = getClass().getResourceAsStream(PATH_CHARACTER + femaleFile)) {
			int bite;
			while ((bite = is.read()) != -1) {
				System.out.print((char) bite);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (InputStream is = getClass().getResourceAsStream(PATH_CHARACTER + maleFile)) {
			int bite;
			while ((bite = is.read()) != -1) {
				System.out.print((char) bite);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAlphabetLoadToMap() {
		
		Map<String,Integer> map = new HashMap<>();
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			map.put(String.valueOf(ch), 0);
		}
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);
		for (Map.Entry<String,Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

}
