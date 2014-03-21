package com.sogou.upd.ufo.lion;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sogou.upd.ufo.lion.utils.Utils;

/**
 * Global configuration from manifest.json.
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.1.0
 */
public final class Config {

	public final static String KEY_TEMPLATE = "template";
	public final static String KEY_CHARSET = "charset";

	private Map<String, Object> manifest = new HashMap<String, Object>();
	private Map<String, Object> defaultManifest = new HashMap<String, Object>();

	private static Config config =null;
	
	private Config(){
		this.init();
	}
	/**
	 * 
	 * @return
	 */
	public synchronized static Config getInstance(){
		if(null==config)
			config=new Config();
		return config;
	}
	/**
	 * Initialize with extra default map.
	 * 
	 * @param extra
	 */
	public void init(Map<String, Object> extra) {
		loadManifest();
		initDefaultManifest(extra);
	}

	/**
	 * Initialize.
	 */
	private void init() {
		this.init(null);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		Object ret = manifest.get(key);
		return null == ret ? defaultManifest.get(key) : ret;
	}

	private void initDefaultManifest(Map<String, Object> extra) {
		defaultManifest.put("template", "freemarker");
		defaultManifest.put("charset", "UTF-8");
		if (null != extra) {
			defaultManifest.putAll(extra);
		}
	}

	private void loadManifest() {
		Gson gson = new Gson();
		Map<String, Object> manifest = gson.fromJson(
				Utils.getFileContent(Application.WD_PREFIX + "/manifest.json","UTF-8"),
				new TypeToken<Map<String, Object>>() {
				}.getType());
		if (null != manifest) {
			this.manifest = manifest;
		}
	}
}
