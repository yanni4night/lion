package com.sogou.upd.ufo.lion.utils;

import java.io.BufferedReader;
import java.io.File;
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
			File file=new File(filename);
			if(file.exists()&&file.isFile()&&file.length()>1024*1024){//TODO configurable
				throw new IllegalAccessException("");
			}
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		} catch (IllegalAccessException e) {
			e.printStackTrace();
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
