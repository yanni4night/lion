package com.sogou.upd.ufo.lion.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * 
	 * @param filename
	 * @return content as String
	 */
	public static String getFileContent(String filename,String charset) {
		StringBuffer content = new StringBuffer();
		BufferedReader br = null;
		try {
			File file=new File(filename);
			if(file.exists()&&file.isFile()&&file.length()>1024*1024){//TODO configurable
				throw new IllegalAccessException("");
			}
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),charset));
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line);
			}
			br.close();
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
				//fr.close();
			} catch (Exception ex) {
			}
		}

		return content.toString();
	}
}
