package com.sogou.upd.ufo.lion.template;

/**
 * Template Engine Settings.
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 */
public final class TemplateEngineSetting {

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static String getTplExtByName(String name) {
		if ("velocity".equalsIgnoreCase(name))
			return ".vm";
		else
			return ".ftl";
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Class<? extends Template> getTemplateClassByName(String name) {
		if ("velocity".equalsIgnoreCase(name)) {
			return VelocityTemplate.class;
		}
		return FreemarkerTemplate.class;
	}

}
