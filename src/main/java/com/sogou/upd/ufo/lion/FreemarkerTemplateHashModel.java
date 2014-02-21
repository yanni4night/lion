package com.sogou.upd.ufo.lion;

import org.json.JSONObject;

import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
/**
 * 
 * @author yinyong
 *
 */
public final class FreemarkerTemplateHashModel implements TemplateHashModel {
		
	private JSONObject json;
	
	public FreemarkerTemplateHashModel(JSONObject json){
			this.json=json;
	}
	@Override
	public TemplateModel get(String key) throws TemplateModelException {
		return new FreemarkerTemplateHashModel(json.getJSONObject(key));
	}

	@Override
	public boolean isEmpty() throws TemplateModelException {
		return json.keySet().isEmpty();
	}

}
