package com.sogou.upd.ufo.lion;


import com.sogou.upd.ufo.lion.utils.FileWalker;

import junit.framework.TestCase;

public class FileWalkerTest extends TestCase {

	public static void main(String[] args) {
		
		FileWalker fw=new FileWalker(Config.WD_TPL_DIR);
		String files[]=fw.getFiles();
		System.out.println(files.length);
	}

}
