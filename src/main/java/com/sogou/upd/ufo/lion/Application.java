package com.sogou.upd.ufo.lion;

import java.lang.reflect.Constructor;

import com.sogou.upd.ufo.lion.template.Template;
import com.sogou.upd.ufo.lion.template.TemplateEngineSetting;

/**
 * Top application context.
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 */
public final class Application {
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

	public static String TPL_EXT = "";
	private static volatile Application instance = new Application();
	private Template template;

	private Config config = new Config();
	private String engineName;

	private Application() {
		super();
		config.init();
		initTemplate();
		TPL_EXT = TemplateEngineSetting.getTplExtByName(engineName);
	}

	private void initTemplate() {
		Object tplEngine = config.get(Config.KEY_TEMPLATE);
		engineName = null;
		try {
			engineName = (String) tplEngine;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}

		Class<? extends Template> clazz = TemplateEngineSetting
				.getTemplateClassByName(engineName);
		try {
			Constructor<? extends Template> constructor = clazz
					.getConstructor();
			template = constructor.newInstance();
			template.init(Application.WD_TPL_DIR);
		} catch (Exception e) {
			template = null;
			e.printStackTrace();
		}
	}

	public Template getTemplate() {
		return template;
	}

	/**
	 * Get global only {@link com.sogou.upd.ufo.lion.Application}
	 * 
	 * @return
	 */
	public static Application getInstance() {
		return instance;
	}
}
