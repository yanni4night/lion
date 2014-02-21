package com.sogou.upd.ufo.lion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handle /
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 */
public class ManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Manager manager;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			manager=new Manager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void doManage(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		if(req.getRequestURI().equals("/index.m")&&null!=manager){
			manager.serveIndex(req, resp);
		}else if(req.getRequestURI().equals("/static.m")&&null!=manager){
			manager.serveStatic(req, resp);
		}else if(req.getRequestURI().equals("/help.m")&&null!=manager){
			manager.serveHelp(req, resp);
		}else{
			resp.sendError(404,req.getRequestURI());
		}
	}	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doManage(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doManage(req, resp);
	}

}
