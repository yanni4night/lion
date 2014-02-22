package com.sogou.upd.ufo.lion.utils;

import java.io.File;
import java.util.LinkedList;

/**
 * Walk a directory and find the exact files.
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 */
public class FileWalker {
	private LinkedList<String> paths = new LinkedList<String>();
	private String rootPath;
	private String[] exts;

	/**
	 * 
	 * @param rootPath
	 */
	public FileWalker(String rootPath) {
		this(rootPath, null);
	}

	/**
	 * 
	 * @param rootPath
	 * @param pattern
	 */
	public FileWalker(String rootPath, String ext) {
		this.rootPath = rootPath;
		this.exts = null == ext ? null : ext.split(",");
	}

	/**
	 * 
	 * @return
	 */
	public String[] getFiles() {
		search(this.rootPath);
		String ret[] = {};
		ret = paths.toArray(ret);
		return ret;
	}

	/**
	 * '
	 * 
	 * @return
	 */
	public String[] getRelFiles() {
		String[] files = getFiles();
		for (int i = files.length - 1; i >= 0; --i) {
			files[i] = files[i].substring(rootPath.length());
		}
		return files;
	}

	private boolean validateExt(String filename) {
		if (exts == null || exts.length == 0) {
			return true;
		}
		for (int i = exts.length - 1; i >= 0; --i) {
			if (filename.endsWith(exts[i]))
				return true;
		}
		return false;
	}

	private String removeExt(String filename) {
		if (exts == null || exts.length == 0) {
			return filename;
		}
		for (int i = exts.length - 1; i >= 0; --i) {
			if (filename.endsWith(exts[i])) {
				return filename.substring(0,
						filename.length() - exts[i].length());
			}
		}
		return filename;
	}

	/**
	 * 
	 * @return
	 */
	public String[] getRelFilesWithoutExt() {
		String[] files = getFiles();
		for (int i = files.length - 1; i >= 0; --i) {
			files[i] = files[i].substring(rootPath.length());
			if (validateExt(files[i])) {
				files[i] = removeExt(files[i]);
			}
		}
		return files;
	}

	private void search(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) {
			return;
		} else if (file.isFile()) {
			if (validateExt(filepath)) {
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
