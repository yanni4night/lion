package com.sogou.upd.ufo.lion;

import com.sogou.upd.ufo.lion.template.FreemarkerTemplate;
import com.sogou.upd.ufo.lion.template.Template;

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
	private static volatile Application instance = new Application();
	private Template template;

	private Config config = new Config();

	private Application() {
		super();
		config.init();
		initTemplate();
	}

	private void initTemplate() {
		Object tplEngine = config.get(Config.KEY_TEMPLATE);
		if ("velocity".equals(tplEngine)) {
			// TODO:velocity to be supported
		} else {
			// freemarker is default
			template = new FreemarkerTemplate();
			try {
				template.init(Application.WD_TPL_DIR);
			} catch (Exception e) {
				template = null;
				e.printStackTrace();
			}
		}
	}

	public Template getTemplate() {
		return template;
	}

	/**
	 * 
	 * @return
	 */
	public static Application getInstance() {
		return instance;
	}
}
