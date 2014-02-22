package com.sogou.upd.ufo.lion.template;

import java.util.Map;


/**
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 */
public interface Template {
	/**
	 * Initialize template engine.
	 * @param tempalteDir
	 * @param params
	 * @throws Exception
	 */
	 void init(String tempalteDir,Object ...params) throws Exception;
	 /**
	  * 
	  * @param tplname
	  * @param data
	  * @return
	  * @throws Exception
	  */
	 String render(String tplname,Map<String, Object> data) throws Exception;
}
