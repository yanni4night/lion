package com.sogou.upd.ufo.lion.template;


/**
 * 
 * @author yinyong
 *
 */
public interface Template {
	/**
	 * 
	 * @param tempalteDir
	 * @throws Exception
	 */
	 void init(String tempalteDir) throws Exception;
	 /**
	  * 
	  * @param tplname
	  * @param data
	  * @return
	  * @throws Exception
	  */
	 String render(String tplname,Object data) throws Exception;
}
