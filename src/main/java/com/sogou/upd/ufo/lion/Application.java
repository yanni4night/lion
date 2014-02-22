package com.sogou.upd.ufo.lion;
/**
 * Top application context.
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 */
public final class Application {
	
	private static Application instance=new Application();
	
	private Config config=new Config();
	private Application(){
		config.init();
	}
	/**
	 * 
	 * @return
	 */
	public static Application getInstance(){
		return instance;
	}
}
