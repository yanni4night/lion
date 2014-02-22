package com.sogou.upd.ufo.lion.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utils.
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 */
public final class Utils {
	/**
	 * Get total content of a file.
	 * @param filename
	 * @return content as String
	 */
	public static String getFileContent(String filename) {
		StringBuffer content = new StringBuffer();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			return "";
		} catch (IOException e) {
			return "";
		} finally {
			try {
				br.close();
				fr.close();
			} catch (Exception ex) {
			}
		}

		return content.toString();
	}
}
