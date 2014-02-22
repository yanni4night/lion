package com.sogou.upd.ufo.lion.template;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * Velocity Template implement.
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 * @see {@link com.sogou.upd.ufo.lion.template.Template}
 */
public class VelocityTemplate implements Template {

	@Override
	public void init(String tempalteDir, Object... params) throws Exception {
		Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, tempalteDir);
		Velocity.init();
	}

	@Override
	public String render(String tplname, Map<String, Object> data)
			throws Exception {
		VelocityContext context = new VelocityContext();
		Set<String> keysets = data.keySet();
		for (Iterator<String> iterator = keysets.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			context.put(key, data.get(key));
		}
		org.apache.velocity.Template template = null;

		template = Velocity.getTemplate(tplname);

		StringWriter sw = new StringWriter();

		template.merge(context, sw);
		return sw.toString();
	}

}
