package com.sogou.upd.ufo.lion;

import java.io.File;
import java.io.StringWriter;


import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

/**
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 * @see {@link com.sogou.upd.ufo.lion.Template}
 */
public class FreemarkerTemplate implements Template {

	private Configuration cfg;

	@Override
	public void init(String tempalteDir) throws Exception {
		cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(tempalteDir));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
	}

	@Override
	public String render(String tplname, Object data) throws Exception {
		freemarker.template.Template tpl = cfg.getTemplate(tplname);
		StringWriter sw = new StringWriter();
		tpl.process(data, sw);
		return sw.toString();
	}

}
