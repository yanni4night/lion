package com.sogou.upd.ufo.lion.template;


/**
 * 
 * @author yinyong
 *
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
	 String render(String tplname,Object data) throws Exception;
}
