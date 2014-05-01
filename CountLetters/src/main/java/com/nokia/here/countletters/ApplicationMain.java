/**
 * 
 */
package com.nokia.here.countletters;

import java.util.Map;

/**
 * @author Ramon Michael
 * 
 */
public class ApplicationMain {

	private static String femaleFile = "1000-female-names.txt";
	private static String maleFile = "1000-males-names.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			ProcessDefaultFilesImpl processDefaultFiles = new ProcessDefaultFilesImpl();
			Map<String,Integer> alphabetMap = processDefaultFiles.getEmptyAlphabetMap();
			processDefaultFiles.processFiles(alphabetMap, femaleFile);
			processDefaultFiles.processFiles(alphabetMap, maleFile);
			for (Map.Entry<String,Integer> entry : alphabetMap.entrySet()) {
				if (entry.getValue()>0) {
					System.out.println((char)Integer.parseInt(entry.getKey()) + " = " + entry.getValue());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
