package com.sogou.upd.ufo.lion.utils;

import java.io.File;
import java.util.LinkedList;

/**
 * 
 * @author yinyong
 * 
 */
public class FileWalker {
	private LinkedList<String> paths = new LinkedList<String>();
	private String rootPath, ext;
	
	/**
	 * 
	 * @param rootPath
	 */
	public FileWalker(String rootPath) {
		this(rootPath,null);
	}
	/**
	 * 
	 * @param rootPath
	 * @param pattern
	 */
	public FileWalker(String rootPath, String ext) {
		this.rootPath = rootPath;
		this.ext = ext;
	}
	/**
	 * 
	 * @return
	 */
	public String[] getFiles() {
		search(this.rootPath);
		String ret[] = {};
		ret=paths.toArray(ret);
		return ret;
	}
	/**'
	 * 
	 * @return
	 */
	public String[] getRelFiles(){
		String[] files=getFiles();
		for(int i=files.length-1;i>=0;--i){
			files[i]=files[i].substring(rootPath.length());
		}
		return files;
	}
	/**
	 * 
	 * @return
	 */
	public String[] getRelFilesWithoutExt(){
		String[] files=getFiles();
		for(int i=files.length-1;i>=0;--i){
			files[i]=files[i].substring(rootPath.length());
			if(ext!=null&&files[i].endsWith(ext)){
				files[i]=files[i].substring(0,files[i].length()-ext.length());
			}
		}
		return files;
	}

	private void search(String filepath) {
		File file = new File(filepath);
		if(!file.exists()){
			return;
		}
		else if (file.isFile()) {
			if (ext != null && file.getName().endsWith(ext)) {
				paths.add(filepath);
			} else if (null == ext) {
				paths.add(filepath);
			}
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0, len = files.length; i < len; ++i) {
				search(files[i].getPath());
			}
		}
	}
}
