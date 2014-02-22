package com.sogou.upd.ufo.lion;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sogou.upd.ufo.lion.utils.Utils;

/**
 * Global configuration.
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 */
public final class Config {
	public static String MG_PREFIX = "./src/main/resources";
	public static String MG_TPL_DIR = MG_PREFIX + "/template";
	/**
	 * root of working-directory
	 */
	public static String WD_PREFIX = "./src/main/webapp";
	/**
	 * JSON data directory in working-directory
	 */
	public static String WD_DATA_DIR = WD_PREFIX + "/_data";
	/**
	 * templates directory in working-directory
	 */
	public static String WD_TPL_DIR = WD_PREFIX + "/template";
	/**
	 * static resources directory in working-directory
	 */
	public static String WD_STATIC_DIR = WD_PREFIX + "/static";
	/**
	 * javascript directory in working-directory
	 */
	public static String WD_JS_DIR = WD_STATIC_DIR + "/js";
	/**
	 * css directory in working-directory
	 */
	public static String WD_CSS_DIR = WD_STATIC_DIR + "/css";
	/**
	 * images directory in working-directory
	 */
	public static String WD_IMG_DIR = WD_STATIC_DIR + "/img";

	private boolean initialized = false;
	
	private  Map<String, Object>  manifest=new HashMap<String, Object>();
	/**
	 * Initialize.
	 * 
	 * @since 1.0.0
	 */
	public void init() {
		if (initialized)
			return;
		loadManifest();
		initialized = true;
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key){
		return manifest.get(key);
	}
	
	private void loadManifest() {
		Gson gson = new Gson();
		Map<String, Object> manifest = gson.fromJson(
				Utils.getFileContent(Config.WD_PREFIX + "/manifest.json"),
				new TypeToken<Map<String, Object>>() {
				}.getType());
		if(null!=manifest){
			this.manifest=manifest;
		}
	}
}
