package com.sogou.upd.ufo.lion;

import junit.framework.TestCase;

public class ConfigTest extends TestCase {
	public static void main(String[] args) {

		Config config =Config.getInstance();
		System.out.println(config.get("template"));
		System.out.println(config.get("charset"));
	}
}
